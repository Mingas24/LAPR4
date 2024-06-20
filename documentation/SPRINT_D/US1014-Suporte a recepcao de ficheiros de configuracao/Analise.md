# US1014-Suporte a recepcao de ficheiros de configuracao

## Objectivo

O Gestor de Projeto pretende que o simulador de maquina suporte a recepcao de ficheiros de configuracao.

## Critérios de aceitação/Observações

Deve ser concorrente (em C) com o resto da simulação da máquina e o estado deve ser partilhado entre threads.

## Pre-requisitos

- A maquina deve receber um pedido de CONFIG do sistema central

## Pos-requisitos

- A maquina recebe e processa o pedido de CONFIG

## Contexto de Execucao

- O US é usado quando se pretende simular um pedido de CONFIG  