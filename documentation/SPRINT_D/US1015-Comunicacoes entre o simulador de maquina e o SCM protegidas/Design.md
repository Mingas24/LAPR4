# US1015-Comunicacoes entre o simulador de maquina e o SCM protegidas

## Design

Utilizar a estrutura base da aplicacao baseada em camadas.

- **Bibliotecas usadas:** 

\#include <stdlib.h>

\#include <unistd.h>

\#include <stdio.h>

\#include <string.h>

\#include <sys/types.h>

\#include <sys/socket.h>

\#include <netinet/in.h>

\#include <arpa/inet.h>

\#include <netdb.h>

\#include <string.h>

\#include <pthread.h>

\#include <openssl/crypto.h>

\#include <openssl/ssl.h>

\#include <openssl/err.h>

\#include <openssl/conf.h>

\#include <openssl/x509.h>

## Sequence Diagram![SD_US1015](.\SD_US1015.png)

## Sequence Diagram Text

title SD_US1015

Machine_Server.c -> main:
main -> US1011_Main: pthread_create(&thread_US1014,NULL,US1014main,(void*)args)
main -> US1011_Main: pthread_join(thread_US1014,NULL)
note right of US1011_Main : O US1015 é uma adição ao US1011
US1011_Main -> <openssl/ssl.h>:method=SSLv23_client_method()
US1011_Main -> <openssl/ssl.h>:SSL_CTX_new(method)
US1011_Main -> <string.h>:strcpy(line,argv[4])
US1011_Main -> <string.h>:strcat(line,".pem")
US1011_Main -> <string.h>:strcpy(line,argv[4])
US1011_Main -> <string.h>:strcat(line,".key")
US1011_Main -> <openssl/ssl.h>:SSL_CTX_set_verify(ctx, SSL_VERIFY_PEER,NULL)
US1011_Main -> <openssl/ssl.h>:SSL_CTX_load_verify_locations(ctx,SERVER_SSL_CERT_FILE,NULL)
US1011_Main -> <openssl/ssl.h>:SSL_connect(sslConn)
US1011_Main -> <openssl/ssl.h>:cert=SSL_get_peer_certificate(sslConn);
US1011_Main -> <openssl/ssl.h>:X509_free(cert);
note right of US1011_Main : Os reads e writes passam a ser SSLread e SSLwrite