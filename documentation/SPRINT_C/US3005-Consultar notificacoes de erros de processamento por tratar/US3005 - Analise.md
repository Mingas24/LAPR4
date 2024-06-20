# US3005 - Consultar notificacoes de erros de processamento por tratar



## Objetivo

O objetivo deste caso de uso e permitir ao gestor de chao de fabrica consultar as notificacoes de erro geradas no processamento das mensagens. 

Com esta funcionalidade, o gesto de chao de fabrica pode ver todas as notificacoes de erro que ainda nao foram tratadas para que possa manualmente proceder a sua resolucao.



## Pre-Requisitos

- O utilizador deverá estar autenticado como Gestor de chao de fabrica.
- Deverao ter sido processadas mensagens enviadas pelas maquinas para que possam ter existido erros de processamento.
- Deverao existir notificacoes de erros que estejam por tratar



## Pos-Requisitos

As notificacoes sao visualizadas pelo utilizador para que este possa proceder a sua resolucao.



## Contexto de Execucao

As notificacoes de erro geradas no processamento das mensagens enviadas pelas maquinas sao guardadas assumindo o estado de "por tratar" ate que o utilizador altere manualmente o estado das mesmas. Todas as notificacoes sao apresentadas ao utilizador cabendo a este decidir o que fazer em relacao a cada uma. As notificacoes sao apresentadas sob forma de uma lista e em cada elemento e mostrado o codigo da notificao, a sua data, o tipo de erro e o identificador da maquina que gerou a mensagem que foi processada com erro.
