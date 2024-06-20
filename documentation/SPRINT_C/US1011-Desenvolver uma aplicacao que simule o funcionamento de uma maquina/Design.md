# US1011-Desenvolver uma aplicacao que simule o funcionamento de uma máquina

## Design

Utilizar a estrutura base da aplicacao baseada em camadas.

- **Bibliotecas usadas:** 

  #include <stdlib.h>
  #include <unistd.h>
  #include <stdio.h>
  #include <string.h>
  #include <sys/types.h>
  #include <sys/socket.h>
  #include <netinet/in.h>
  #include <arpa/inet.h>
  #include <netdb.h>

  #include<pthread.h>

## Sequence Diagram![SD_US1011](.\SD_US1011.png)

## Sequence Diagram text

title SD_US1011

US1011.c->main:
main->US1011Main:pthread_create(&thread_US1011,NULL,US1011main,(void*)args)
main->US1011Main:ptread_join(thread_US1011,NULL)
US1011Main-><unistd.h>:write(sock,&bt,messageTotalLength)
US1011Main-><unistd.h>:read(sock,&bt,messageTotalLength)
US1011Main-><stdio.h>:sprintf(nameFile,"%d.txt",idMac)
US1011Main->><stdio.h>:file = fopen(nameFile,"r")
US1011Main-><stdio.h>:fgets(rawData, 512, file)
US1011Main-><unistd.h>:write(sock,&bt,messageTotalLength)
US1011Main-><unistd.h>:sleep(cad)
US1011Main-><unistd.h>:read(sock,&bt,messageTotalLength)
US1011Main-><pthread.h>:pthread_exit(NULL)