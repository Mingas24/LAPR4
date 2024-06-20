# US2009 Importar Ordens de Producao a Partir de CSV

## Objetivo:

O objetivo deste caso de uso e introduzir automaticamente uma lista de novas ordens de producao para que possam ser executadas. 

## Pre-requisitos:

- O utilizador deverá estar autenticado como Gestor de Producao.
- Deverao existir produtos registados para que possam ser produzidos
- A fabrica devera ter recebido encomendas para poder produzir em funcao das mesmas
- Ficheiro CSV com uma lista de ordens de producao validas.

## Pos-requisitos:

As ordens de producao sao guardadas no sistema, assumindo o estado pendente ate comecarem a ser executadas.

## Contexto de execucao:

Este UC deve ser inicializado quando for necessario o carregamento de ordens de producao  para o sistema. A ordem de producao assume o estado pendente ao ser criada.

## Regras de negocio:

- O produto indicado deve obrigatoriamente existir.
- O produto e identificado pelo seu codigo unico de fabrico.
- Se o produto ainda nao tiver ficha de producao, a ordem de producao pode ser criada mas o utilizador deve ser avisado.
- O identificador da ordem de producao e da(s) encomenda(s) deve ser um codigo alfanumerico.
- A mesma encomenda pode estar referida em mais do que uma ordem de producao.
- Uma ordem de producao pode ser referente a mais do que uma encomenda.
- A data prevista de execucao deve ser igual ou posterior a data de emissao.
- Os estados possiveis para a ordem de producao sao: "pendente", "em execucao", "execucao parada temporariamente", "concluida" e "suspensa".