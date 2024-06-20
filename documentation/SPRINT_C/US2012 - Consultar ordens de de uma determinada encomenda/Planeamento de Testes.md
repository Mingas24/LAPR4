# US2012 - Consultar ordens de de uma determinada encomenda

## Testes Unitarios para as invariantes do sistema

- ensureOrderIDIsEmpty
- ensureOrderIDExists
- ensureOrderIDIsValide
- ensureProductionOrderExists

## Plano de Testes Funcionais e de Aceitacao

### Caso #1 - Consultar Ordens de Producao de uma encomenda

1. Fazer login como gestor de producao

2. Escolher opcao "consultar ordens de producao de uma encomenda"

3. Introduzir o identificador da encomenda

4. submeter a informacao

5. o sistema valida e informa o utilizador do sucesso da operacao

### Caso #2 -Consultar uma ordem de producao sem identificador de encomenda

1. Fazer login como gestor de producao
2. Escolher opcao "consultar ordens de producao de uma encomenda"

3. Não introduz o identificador da encomenda
4. submeter a informacao
5. o sistema avisa o utilizador que o identificador da encomenda nao foi inserido

### Caso #3 -Consultar uma ordem de producao com identificador de encomenda nao existente

1. Fazer login como gestor de producao
2. Escolher opcao "consultar ordens de producao de uma encomenda"

3. Introduz o identificador da encomenda nao existente
4. submeter a informacao
5. o sistema avisa o utilizador que o identificador da encomenda nao foi inserido

### Caso #4 -Consultar uma ordem de producao com identificador de encomenda invalido

1. Fazer login como gestor de producao
2. Escolher opcao "consultar ordens de producao de uma encomenda"

3. Introduz o identificador da encomenda invalido
4. submeter a informacao
5. o sistema avisa o utilizador que o identificador da encomenda e invalido

### Caso #5 -Consultar uma ordem de producao sem existir ordem de producao

1. Fazer login como gestor de producao
2. Escolher opcao "consultar ordens de producao de uma encomenda"

3. Introduz o identificador da encomenda
4. submeter a informacao
5. o sistema avisa o utilizador nao existe nenhuma ordem de producao