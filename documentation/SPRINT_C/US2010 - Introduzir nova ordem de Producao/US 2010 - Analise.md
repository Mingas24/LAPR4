# US 2010 - Introduzir Nova Ordem de Producao 



## Objetivo

O objetivo deste caso de uso e introduzir manualmente uma nova ordem de producao para que possa ser executada. 

Ao  criar uma ordem de producao devera ser introduzido um identificador, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e o(s) identicador(es) da(s) encomenda(s). Ao ser criada, a ordem de producao assume o estado "pendente".



## Pre-Requisitos

- O utilizador deverá estar autenticado como Gestor de Producao.
- Deverao existir produtos registados para que possam ser produzidos
- A fabrica devera ter recebido encomendas para poder produzir em funcao das mesmas



## Pos-Requisitos

A ordem de producao e guardada no sistema, assumindo o estado pendente ate comecar a ser executada.



## Contexto de Execucao

E necessario o utilizador criar uma ordem de producao para que esta possa ser executada de modo a produzir os produtos pretendidos para uma ou várias encomendas. A ordem de producao assume o estado pendente ao ser criada.



## Regras de negocio

- O produto indicado deve obrigatoriamente existir.
- O produto e identificado pelo seu codigo unico de fabrico.
- Se o produto ainda nao tiver ficha de producao, a ordem de producao pode ser criada mas o utilizador deve ser avisado.
- O identificador da ordem de producao e da(s) encomenda(s) deve ser um codigo alfanumerico.
- A mesma encomenda pode estar referida em mais do que uma ordem de producao.
- Uma ordem de producao pode ser referente a mais do que uma encomenda.
- A data prevista de execucao deve ser igual ou posterior a data de emissao.
- Os estados possiveis para a ordem de producao sao: "pendente", "em execucao", "execucao parada temporariamente", "concluida" e "suspensa".