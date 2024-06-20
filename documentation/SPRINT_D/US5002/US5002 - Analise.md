# US5002-Processar mensagens disponíveis no sistema

## Objetivo

Como Serviço de Processamento de Mensagens (SPM), pretendo efetuar o processamento das mensagens disponiveis no sistema. Nesta US pretende-se acrescentar ao processamento ja realizado anteriormente (US5001) a possibilidade de o fazer de dois modos distintos:

- As mensagens sao processadas em bloco para um intervalo de tempo (Data e hora de inicio e Data e hora de fim) especificado. Apos processar esse bloco o processamento termina.

- As mensagens sao processadas em bloco de forma recorrente em intervalos de tempo definidos a contar de um dado momento especificado. Apos processar todas as mensagens contidas entre o momento inicial e o limite (momento inicial + intervalo de tempo) o servico aguarda ate ser oportuno passar para o bloco seguinte. Repetindo o processo quando o fizer.

## Pre-Requisitos

- Geração e recolha de mensagens realizado (US1011 e US4002 ou US4001).
- Processamento de mensagens feito por linha de producao de forma independente e em paralelo

## Pos-Requisitos

- As mensagens serao processadas e guardadas na base de dados , tendo agora a possibilidade de o fazer de dois modos distintos.

## Contexto de Execução

Esta US deve ser executada aquando existam mensagens para ser processadas pelo SPM.

## Regras de Negócio

* A data e hora de fim nao pode ser anterior a data e hora de inicio
* O intervalo de tempo deve ser validado.
* Deve ser identificada uma mensagem de inicio e fim de atividade(Geracao de notificacao de erro de qualquer outra forma);