# US 3009 - Saber e alterar o estado do processamento de mensagens e conhecer a ultima vez que o mesmo se realizou



## Objetivo

O objetivo deste caso de uso e saber e alterar o estado do processamento de mensagens (ativo/desativo) de cada linha de producao. O utilizador deve tambem poder consultar a data e hora em que ocorreu o ultimo processamento.



## Pre-Requisitos

- O utilizador deverá estar autenticado como Gestor de Chao de Fabrica.
- Deverao existir mensagens por processar e a ser processadas
- A linha de producao devera ter um novo atributo referente ao estado do processamento das mensagens.
- A linha de producao devera ter um novo atributo referente ao momento em que foi realizado o ultimo processamento.



## Pos-Requisitos

O gestor do chao de fabrica podera consultar o estado do processamento de mensagens e altera-lo se desejar. 



## Contexto de Execucao

Cada linha de producao tera um estado referente ao processamento das mensagens das maquinas contidas na mesma. Esse estado pode assumir os valores ativo ou desativo. O utilizador pode consultar este valor e manualmente altera-lo se desejar. Caso o estado seja ativo, o processamento de mensagens para essa linha de producao ocorre ciclicamente. Caso o estado seja desativo, o processamento das mensagens nao ocorre podendo o gestor do chao de fabrica pedir o reprocessamento para um dado intervalo de tempo.



## Regras de negocio

- O estado do processamento das mensagens pode ser ativo ou desativo.
- Devera ser guardado um atributo com a data e hora do ultimo processamento de mensagens na linha de producao.