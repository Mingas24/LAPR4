# US1015-Comunicacoes entre o simulador de maquina e o SCM protegidas

## Plano de Testes Funcionais e de Aceitacao

### Caso #1 - Comunicacoes entre o simulador de maquina e o SCM protegidas com sucesso

1. O simulador e executado
2. Introduzir  ip, o id do protocolo , a cadencia e nome das chaves
3. submeter a informacao
4. o sistema valida e prossegue com a execucao do US1011/US1014

### Caso #2 -Comunicacoes entre o simulador de maquina e o SCM protegidas sem chaves

1. O simulador e executado
2. Introduzir  ip, o id do protocolo , a cadencia e sem nome das chaves
3. submeter a informacao
4. o sistema avisa o utilizador do erro

### Caso #3 -Comunicacoes entre o simulador de maquina e o SCM protegidas com chave errada

1. O simulador e executado
2. Introduzir  ip, o id do protocolo , a cadencia e com nome das chaves erradas
3. submeter a informacao
4. o sistema avisa o utilizador do erro