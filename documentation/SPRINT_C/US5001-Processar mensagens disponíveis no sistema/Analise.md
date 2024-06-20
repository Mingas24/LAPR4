# US5001-Processar mensagens disponíveis no sistema

## Objectivo

Como Serviço de Processamento de Mensagens (SPM), pretendo efetuar o processamento das mensagens disponiveis no sistema.

## Pre-Requisitos

- Geração e recolha de mensagens realizado (US1011 e US4002 ou US4001)

## Pos-Requisitos

- As mensagens serao processadas e guardadas na base de dados

## Contexto de Execução

Este US deve ser executado aquando o fim do US4002 ou US4001

## Regras de Negócio

* As linhas de produção são especificadas pelo utilizador.
* O intervalo de tempo deve ser validado.
* Deve ser identificada uma mensagem de inicio e fim de atividade(Geracao de notificacao de erro de qualquer outra forma);