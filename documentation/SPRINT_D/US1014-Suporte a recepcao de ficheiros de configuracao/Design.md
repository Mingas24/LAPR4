# US1014-Suporte a recepcao de ficheiros de configuracao

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

## Sequence Diagram 

![SD_US1014](.\SD_US1014.png)

## Sequence Diagram Text

title SD_US1014

Machine_Server.c -> main:
main -> US1011_Main: pthread_create(&thread_US1014,NULL,US1014main,(void*)args)

main -> US1011_Main: pthread_join(thread_US1014,NULL)
US1011_Main -> US1014_Main: pthread_create(&thread_US1014,NULL,US1014main,(void*)args)
US1011_Main -> US1014_Main: pthread_join(thread_US1014,NULL)
US1014_Main -> <unistd.h>:read(newSock, &bt, 512);
US1014_Main -> <unistd.h>:write(newSock, &bt, 512);