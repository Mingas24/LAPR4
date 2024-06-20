# US1012-Simulador deve suportar pedidos de monitorização do seu estado



## Design

Utilizar a estrutura da aplicacao baseada em camadas



**Bibliotecas utilizadas:**

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

​	

## Sequence Diagram

![SD-US1012](.\SD-US1012.png)



## Sequence Diagram code

title US1012

US1011.c->main: 
main->US1012main: pthread_create(&thread_US1012, NULL, US1012main(void*)args)



main->US1012main: pthread_join(thread_US1012, NULL) 



