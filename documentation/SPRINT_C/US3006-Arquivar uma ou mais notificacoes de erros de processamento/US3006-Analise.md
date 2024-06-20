# US3006-Arquivar uma ou mais notificacoes de erros de processamento



## Objetivo

O objetivo deste caso de uso e permitir ao gestor de chao de fabrica arquivar notificacoes de erros de processamento depois de os ter resolvido manualmente

Com esta funcionalidade, o gesto de chao de fabrica pode arquivar todas as notificacoes de erro estao por tratar, isto e, mudar o seu estado para arquivado

## Pre-Requisitos

- O utilizador deverá estar autenticado como Gestor de chao de fabrica.
- Deverao ter sido processadas mensagens enviadas pelas maquinas para que possam ter existido erros de processamento.
- Deverao existir notificacoes de erros que estejam por tratar



## Pos-Requisitos

As notificacoes ficam arquivadas, sendo o seu estado alterado para arquivado



## Contexto de Execucao

Quando um gestor de chao de fabrica decide arquivar uma notificacao por ja ter manualmente resolvido a mesma esta passa a assumir o estado arquivada. Com esta us o gestor de chao de fabrica pode arquivar uma notificacao se conclui que ja foi corrigido o erro e nao e mais necessario ser considerada como "a tratar".