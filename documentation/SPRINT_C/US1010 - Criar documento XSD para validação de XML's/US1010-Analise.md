# US1010 Criar documento XSD para validação de XML's

## Objetivo:

Este UC tem como objetivo a criação de um documento XSD para a validação dos ficheiros XML criados pelo sistema. Irá existir um ficheiro XSD capaz de verificar diferentes tipos de ficheiro XML, dependendo do seu conteúdo.

## Pre-requisitos:

n/a

## Pos-requisitos:

O ficheiro é guardado e usado para a validação posterior dos ficheiros XML.

## Contexto de execucao:

O ficheiro XSD será utilizado na validação aquando da criação dos diferentes ficheiros XML. O ficheiro será capaz de validar diferentes ficheiros XML independentemente do seu conteúdo.

## Restricoes Necessarias:

| Restricoes | Funcao                                                       | Elemento/Atributo em questão |
| ---------- | ------------------------------------------------------------ | ---------------------------- |
| Estado     | O estado e uma enumeração que apenas pode aceitar os valores PENDING IN_EXECUTION EXECUTION_TEMPORARILY_STOP FINISHED SUSPENDED | State                        |
| Unidade    | A unidade e uma enumeração que apenas pode aceitar os valores UN KG L METERS | Unity                        |
| Quantidade | A Quantidade tem de ser um numero nao negativo               | Quantity                     |
