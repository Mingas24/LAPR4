# US1016-Simulador de maquinas suporta pedidos de reinicializacao (reset) do seu estado



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





## Sequence Diagram

![SD-US1016](.\SD-US1016.png)









## Sequence Diagram code



title US1016

SMM->main: 

main->main: pthread_mutex_init(&mutex_RESET, NULL);
main->main: pthread_mutex_init(&mutex_SLEEP, NULL);


main->thread_server: pthread_create(&thread_US1012, NULL, US1012main, (void *)args)
main->thread_client: pthread_create(&thread_US1011, NULL, US1011main, (void *)args);
main->thread_client: pthread_join(thread_US1011, NULL);
main->thread_server: pthread_join(thread_US1012, NULL);

main->main: pthread_mutex_destroy(pthread_mutex_t *mutex_RESET)
main->main: pthread_mutex_destroy(pthread_mutex_t *mutex_SLEEP)

