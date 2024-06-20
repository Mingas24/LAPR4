#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <string.h>
#include <pthread.h>
#include <openssl/crypto.h>
#include <openssl/ssl.h>
#include <openssl/err.h>
#include <openssl/conf.h>
#include <openssl/x509.h>

#define BUF_SIZE 30
#define SERVER_PORT "30803"
pthread_mutex_t mutex_US1011;
pthread_mutex_t mutex_RESET;
pthread_mutex_t mutex_SLEEP;
// read a string from stdin protecting buffer overflow
#define GETS(B, S)              \
    {                           \
        fgets(B, S - 2, stdin); \
        B[strlen(B) - 1] = 0;   \
    }
#define VERSION_INDEX 0
#define CODE_INDEX 1
#define ID_INDEX 2
#define DATA_LENGTH_INDEX 4
#define RAW_DATA_INDEX 6
#define HELLO_REQUEST 0
#define MSG_REQUEST 1
#define CONFIG_REQUEST 2
#define RESET_REQUEST 3
#define ACK 150
#define NACK 151

#define SERVER_SSL_CERT_FILE "server.pem"

typedef struct
{
    unsigned int idMac;
    unsigned int cad;
    int argc;
    char **argv;
    int flag;
    char checkRawData[506];
    char security[50];
} arguments;

/****US1014****/
//tcp Server
void *US1014main(void *args)
{

    struct sockaddr_storage from;
    FILE *file = NULL;
    unsigned int idMac = (intptr_t)args;
    unsigned char bt[512];
    char rawData[506] = "";
    int err, newSock, sock;
    unsigned int adl;
    char cliIPtext[BUF_SIZE], cliPortText[BUF_SIZE];
    struct addrinfo req, *list;

    bzero((char *)&req, sizeof(req));
    // requesting a IPv6 local address will allow both IPv4 and IPv6 clients to use it
    req.ai_family = AF_INET6;
    req.ai_socktype = SOCK_STREAM;
    req.ai_flags = AI_PASSIVE; // local address

    err = getaddrinfo(NULL, SERVER_PORT, &req, &list);

    if (err)
    {
        printf("Failed to get local address, error: %s\n", gai_strerror(err));
        exit(1);
    }

    sock = socket(list->ai_family, list->ai_socktype, list->ai_protocol);
    if (sock == -1)
    {
        perror("Failed to open socket");
        freeaddrinfo(list);
        exit(1);
    }

    if (bind(sock, (struct sockaddr *)list->ai_addr, list->ai_addrlen) == -1)
    {
        perror("Bind failed");
        close(sock);
        freeaddrinfo(list);
        exit(1);
    }

    freeaddrinfo(list);

    listen(sock, SOMAXCONN);

    puts("Accepting TCP connections (both over IPv6 or IPv4). Use CTRL+C to terminate the server");

    adl = sizeof(from);

    while (1)
    {
        newSock = accept(sock, (struct sockaddr *)&from, &adl);
        close(sock);
        getnameinfo((struct sockaddr *)&from, adl, cliIPtext, BUF_SIZE, cliPortText, BUF_SIZE, NI_NUMERICHOST | NI_NUMERICSERV);
        printf("New connection from node %s, port number %s\n", cliIPtext, cliPortText);

        read(newSock, &bt, 512);

        if (bt[1] != 2)
        {
            printf("The code is not correct");
            bt[1] = 151;
            pthread_exit(NULL);
        }
        unsigned int number = bt[2] | bt[3] << 8;
        if (number != idMac)
        {
            printf("The machines are not the same");
            bt[1] = 151;
            pthread_exit(NULL);
        }

        char nameFile[20];
        sprintf(nameFile, "%d_Config.txt", idMac);
        if ((file = fopen(nameFile, "rw")) == NULL)
        {
            printf("Error\n");
            pthread_exit(NULL);
        }
        while (fgets(rawData, 512, file) != NULL)
        {
            fprintf(file, "%s", rawData);
        }

        bt[0] = 0;
        bt[1] = 150;
        memcpy(&bt[6], "CONFIG RECEIVED", 506);
        int dataLenght = strlen(rawData) + 6;
        bt[4] = (char)(dataLenght >> (8 * 1)) & 0xff;
        bt[5] = (char)(dataLenght >> (8 * 0)) & 0xff;
        write(newSock, &bt, 512);
    }
    fclose(file);
    close(newSock);
    pthread_exit(NULL);
}

/****US1011****/
//tcp Client
void *US1011main(void *args)
{
    FILE *file;
    int err, sock;
    unsigned int dataLength;
    unsigned char bt[512], version, code;
    char rawData[506] = "";
    char line[100];
    struct addrinfo req, *list;

    arguments *argument = (arguments *)args;
    unsigned int idMac = (argument->idMac);
    unsigned int cad = (argument->cad);
    int argc = argument->argc;
    char **argv = (char **)argument->argv;

    if (argc != 5)
    {
        puts("Server's IPv4/IPv6 address or DNS name is required as argument");
        exit(1);
    }

    bzero((char *)&req, sizeof(req));
    // let getaddrinfo set the family depending on the supplied server address
    req.ai_family = AF_UNSPEC;
    req.ai_socktype = SOCK_STREAM;
    err = getaddrinfo(argv[1], SERVER_PORT, &req, &list);
    if (err)
    {
        printf("Failed to get server address, error: %s\n", gai_strerror(err));
        exit(1);
    }

    sock = socket(list->ai_family, list->ai_socktype, list->ai_protocol);
    if (sock == -1)
    {
        perror("Failed to open socket\n");
        freeaddrinfo(list);
        exit(1);
    }

    if (connect(sock, (struct sockaddr *)list->ai_addr, list->ai_addrlen) == -1)
    {
        perror("Failed connect\n");
        printf("Erro 1011");
        freeaddrinfo(list);
        close(sock);
        exit(1);
    }

    const SSL_METHOD *method = SSLv23_client_method();
    SSL_CTX *ctx = SSL_CTX_new(method);

    if (argc == 5)
    {
        // Load client's certificate and key
        strcpy(line, argv[4]);
        strcat(line, ".pem");
        SSL_CTX_use_certificate_file(ctx, line, SSL_FILETYPE_PEM);
        strcpy(line, argv[4]);
        strcat(line, ".key");
        SSL_CTX_use_PrivateKey_file(ctx, line, SSL_FILETYPE_PEM);
        if (!SSL_CTX_check_private_key(ctx))
        {
            puts("Error loading client's certificate/key");
            close(sock);
            exit(1);
        }
    }

    SSL_CTX_set_verify(ctx, SSL_VERIFY_PEER, NULL);

    // THE SERVER'S CERTIFICATE IS TRUSTED
    SSL_CTX_load_verify_locations(ctx, SERVER_SSL_CERT_FILE, NULL);

    // Restrict TLS version and cypher suites
    SSL_CTX_set_min_proto_version(ctx, TLS1_2_VERSION);
    SSL_CTX_set_cipher_list(ctx, "HIGH:!aNULL:!kRSA:!PSK:!SRP:!MD5:!RC4");

    SSL *sslConn = SSL_new(ctx);
    SSL_set_fd(sslConn, sock);
    if (SSL_connect(sslConn) != 1)
    {
        puts("TLS handshake error");
        SSL_free(sslConn);
        close(sock);
        exit(1);
    }
    printf("TLS version: %s\nCypher suite: %s\n", SSL_get_cipher_version(sslConn), SSL_get_cipher(sslConn));

    if (SSL_get_verify_result(sslConn) != X509_V_OK)
    {
        puts("Sorry: invalid server certificate");
        SSL_free(sslConn);
        close(sock);
        exit(1);
    }

    X509 *cert = SSL_get_peer_certificate(sslConn);
    X509_free(cert);

    if (cert == NULL)
    {
        puts("Sorry: no certificate provided by the server");
        SSL_free(sslConn);
        close(sock);
        exit(1);
    }

    if (idMac < 1 || idMac > 65535)
    {
        printf("Invalid ID Machine\n");
        pthread_exit(NULL);
    }

    version = 0;
    code = 0;
    bt[0] = version;
    bt[1] = code;

    int msb = (idMac >> (8 * 1)) & 0xff;
    int lsb = (idMac >> (8 * 0)) & 0xff;
    bt[2] = (char)msb;
    bt[3] = (char)lsb;
    dataLength = strlen(rawData) + 1;
    int messageTotalLength = 6 + dataLength;
    bt[4] = (char)(messageTotalLength >> (8 * 1)) & 0xff;
    bt[5] = (char)(messageTotalLength >> (8 * 0)) & 0xff;
    memcpy(&bt[6], rawData, dataLength);
    strcpy(argument->checkRawData, rawData);
    SSL_write(sslConn, &bt, messageTotalLength);
    SSL_read(sslConn, &bt, messageTotalLength);

    if (bt[1] == 151)
    {
        printf("The Machine ID is not recognized by the system.\nRequest has been refused or ignored");
        pthread_mutex_lock(&mutex_US1011);
        argument->flag = 1;
        pthread_mutex_unlock(&mutex_US1011);
        pthread_exit(NULL);
    }

    //US1014 Thread//
    pthread_t thread_US1014;
    pthread_create(&thread_US1014, NULL, US1014main, (void *)(intptr_t)idMac);
    //pthread_join(thread_US1014, NULL);

    char nameFile[20];
    sprintf(nameFile, "%d.txt", idMac);
    if ((file = fopen(nameFile, "r")) == NULL)
    {
        printf("Error\n");
        pthread_exit(NULL);
    }

    while (1)
    {
        if (fgets(rawData, 512, file) != NULL)
        {
            bt[0] = version;
            bt[1] = 1;
            dataLength = strlen(rawData) + 1;
            messageTotalLength = 6 + dataLength;
            bt[4] = (messageTotalLength >> (8 * 1)) & 0xff;
            bt[5] = (messageTotalLength >> (8 * 0)) & 0xff;
            memcpy(&bt[6], rawData, dataLength);
            strcpy(argument->checkRawData, rawData);
            puts(rawData);
            SSL_write(sslConn, &bt, messageTotalLength);
            SSL_read(sslConn, &bt, messageTotalLength);
            //memset(rawData,0,strlen(rawData));
            if (bt[1] == 151)
            {
                printf("Error processing the message");
                pthread_mutex_lock(&mutex_US1011);
                argument->flag = 1;
                pthread_mutex_unlock(&mutex_US1011);
                exit(5);
            }
        }
        else
        {
            pthread_mutex_lock(&mutex_US1011);
            argument->flag = 2;
            pthread_mutex_unlock(&mutex_US1011);
        }
        sleep(cad);
    }
    fclose(file);
    close(sock);
    pthread_exit(NULL);
}

/****US1012****/
//udp Server
void *US1012main(void *args)
{
    arguments *argument = (arguments *)args;
    struct sockaddr_storage client;
    int err, sock, res;
    unsigned int adl;
    char line[BUF_SIZE];
    char cliIPtext[BUF_SIZE], cliPortText[BUF_SIZE];
    struct addrinfo req, *list;

    bzero((char *)&req, sizeof(req));
    // request a IPv6 local address will allow both IPv4 and IPv6 clients to use it
    req.ai_family = AF_INET;
    req.ai_socktype = SOCK_DGRAM;
    req.ai_flags = AI_PASSIVE; // local address

    err = getaddrinfo(NULL, SERVER_PORT, &req, &list);

    if (err)
    {
        printf("Failed to get local address, error: %s\n", gai_strerror(err));
        exit(1);
    }

    sock = socket(list->ai_family, list->ai_socktype, list->ai_protocol);
    if (sock == -1)
    {
        perror("Failed to open socket");
        freeaddrinfo(list);
        exit(1);
    }

    if (bind(sock, (struct sockaddr *)list->ai_addr, list->ai_addrlen) == -1)
    {
        perror("Bind failed");
        close(sock);
        freeaddrinfo(list);
        exit(1);
    }

    freeaddrinfo(list);

    puts("Listening for UDP requests (both over IPv6 or IPv4). Use CTRL+C to terminate the server");

    adl = sizeof(client);
    while (1)
    {
        res = recvfrom(sock, line, BUF_SIZE, 0, (struct sockaddr *)&client, &adl);
        if (res == 0)
        {
            perror("Received Empty Message");
            exit(1);
        }

        printf("asdfgh\n");
        if (!getnameinfo((struct sockaddr *)&client, adl,
                         cliIPtext, BUF_SIZE, cliPortText, BUF_SIZE, NI_NUMERICHOST | NI_NUMERICSERV))
            printf("Request from node %s, port number %s\n", cliIPtext, cliPortText);
        else
            puts("Got request, but failed to get client address");
        int i;
        //response to the request HELLO
        if (line[CODE_INDEX] == HELLO_REQUEST)
        {
            //forces version to be the default value 0
            line[VERSION_INDEX] = 0;
            line[CODE_INDEX] = (char)argument->flag;
            //splits the machine ID between 2 variables (2 bytes)
            unsigned char byteFirstPartOfID = (unsigned)argument->idMac & 0xff;
            unsigned char byteSecondPartOfID = (unsigned)argument->idMac >> 8;
            //assign the bytes to the respective part of the line
            line[ID_INDEX] = byteFirstPartOfID;
            line[ID_INDEX + 1] = byteSecondPartOfID;
            //check if there is information on rawData
            if (sizeof(line) > 6)
            { //if the line > 6 bytes, this means that there is content in raw data
                //get size of rawData
                int rawData_size = strlen(argument->checkRawData);
                //splits the size of the raw data between 2 variables
                unsigned char byteFirstPartOfDataSize = (unsigned)rawData_size & 0xff;
                unsigned char byteSecondPartOfDataSize = (unsigned)rawData_size >> 8;
                //assign the bytes to the respective part of the line
                line[DATA_LENGTH_INDEX] = byteFirstPartOfDataSize;
                line[DATA_LENGTH_INDEX + 1] = byteSecondPartOfDataSize;

                //fill in rawData
                for (i = 0; i < rawData_size; i++)
                {
                    line[RAW_DATA_INDEX + i] = argument->checkRawData[i];
                }
            }
            else
            {
                //if there is no information on rawData index=0
                line[DATA_LENGTH_INDEX] = 0;
            }
            //replies the request
            err = sendto(sock, line, res, 0, (struct sockaddr *)&client, adl);
            printf("Answear Sent\n");
            //checks if there was an error sending the message
            if (err < 0)
            {
                perror("Error sending message");
                pthread_exit(NULL);
                exit(1);
            }
            //resets the message code to ACK
            argument->flag = 0;
        }

        /*----- US1016 --------------*/
        else if (line[DATA_LENGTH_INDEX] == RESET_REQUEST)
        {

            pthread_mutex_lock(&mutex_RESET);

            pthread_mutex_lock(&mutex_SLEEP);
            sleep(15); //reset the machine

            pthread_mutex_unlock(&mutex_SLEEP);

            //forces version to be the default value 0
            line[VERSION_INDEX] = 0;
            line[CODE_INDEX] = (char)argument->flag;
            //splits the machine ID between 2 variables (2 bytes)
            unsigned char byteFirstPartOfID = (unsigned)argument->idMac & 0xff;
            unsigned char byteSecondPartOfID = (unsigned)argument->idMac >> 8;
            //assign the bytes to the respective part of the line
            line[ID_INDEX] = byteFirstPartOfID;
            line[ID_INDEX + 1] = byteSecondPartOfID;
            //check if there is information on rawData
            if (sizeof(line) > 6)
            { //if the line > 6 bytes, this means that there is content in raw data
                //get size of rawData
                int rawData_size = strlen(argument->checkRawData);
                //splits the size of the raw data between 2 variables
                unsigned char byteFirstPartOfDataSize = (unsigned)rawData_size & 0xff;
                unsigned char byteSecondPartOfDataSize = (unsigned)rawData_size >> 8;
                //assign the bytes to the respective part of the line
                line[DATA_LENGTH_INDEX] = byteFirstPartOfDataSize;
                line[DATA_LENGTH_INDEX + 1] = byteSecondPartOfDataSize;

                //fill in rawData
                for (i = 0; i < rawData_size; i++)
                {
                    line[RAW_DATA_INDEX + i] = argument->checkRawData[i];
                }
            }
        }
        /*---------------------------------------------------*/

        else
        {
            printf("Invalid Request");
        }
    }
    //close socket
    close(sock);
    pthread_exit(NULL);
    exit(0);
}

int main(int argc, char **argv)
{
    /****US1011****/
    pthread_t thread_US1011;
    unsigned int idMachine = (unsigned int)atoi(argv[2]);
    unsigned int cadency = (unsigned int)atoi(argv[3]);
    char security[50];
    strcpy(security, argv[4]);
    arguments *args;
    args = malloc(sizeof(arguments));
    args->idMac = idMachine;
    args->cad = cadency;
    args->argc = argc;
    args->argv = argv;
    args->flag = 0;
    strcpy(args->security, security);
    pthread_mutex_init(&mutex_US1011, NULL);
    pthread_create(&thread_US1011, NULL, US1011main, (void *)args);

    /****US1012****/
    pthread_t thread_US1012;
    pthread_create(&thread_US1012, NULL, US1012main, (void *)args);
    pthread_join(thread_US1011, NULL);
    pthread_join(thread_US1012, NULL);

    /****US1016****/

    pthread_mutex_init(&mutex_RESET, NULL);
    pthread_mutex_init(&mutex_SLEEP, NULL);

    pthread_create(&thread_US1012, NULL, US1012main, (void *)args);
    pthread_create(&thread_US1011, NULL, US1011main, (void *)args);

    pthread_join(thread_US1011, NULL);
    pthread_join(thread_US1012, NULL);

    //pthread_mutex_destroy(pthread_mutex_t *mutex_RESET);
    //pthread_mutex_destroy(pthread_mutex_t *mutex_SLEEP);

    return 0;
}
