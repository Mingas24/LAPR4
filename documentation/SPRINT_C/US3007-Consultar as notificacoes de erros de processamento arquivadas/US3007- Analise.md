# US3007-Consultar as notificações de erros de processamento arquivadas



## Objetivo

O objetivo deste caso de uso e permitir ao gestor de chao de fabrica consultar as notificacoes de erro geradas no processamento das mensagens. 

Com esta funcionalidade, o gesto de chao de fabrica pode ver todas as notificacoes de erro que foram arquivadas por um gestor de fabrica, isto e, o seu estado foi alterado para arquivado

## Pre-Requisitos

- O utilizador deverá estar autenticado como Gestor de chao de fabrica.
- Deverao ter sido processadas mensagens enviadas pelas maquinas para que possam ter existido erros de processamento.
- Deverao existir notificacoes de erros que estejam arquivadas



## Pos-Requisitos

As notificacoes ja arquivadas sao visualizadas pelo utilizador.



## Contexto de Execucao

Quando um gesto de chao de fabrica decide arquivar uma notificacao por ja ter manualmente resolvido a mesma esta passa a assumir o estado arquivada. Com esta us o gestor de chao de fabrica pode consultar todas as notificacoes que ja foram arquivadas e tem o estado arquivada. As notificacoes sao apresentadas sob forma de uma lista e em cada elemento e mostrado o codigo da notificao, a sua data, o tipo de erro e o identificador da maquina que gerou a mensagem que foi processada com erro.