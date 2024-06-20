# US2011-Consultar ordens de producao em determinado estado

## Planeamento de Testes Unitarios a invariantes de negocio

### ProductionOrder:

- testListProductionOrderWithInvalidState
- testListProductionOrderWithEmptyState





## Planeamento de testes funcionais e de Aceitacao

### Caso #1- Consultar uma ordem de producao em determinado estado

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Consultar ordens de producao"
3. Introduzir o estado para o qual se pretende consultar as ordens de producao 
4. Submeter informacao
5. O sistema valida e apresenta a informacao solicitada

### Caso #2- Consultar uma ordem de producao em determinado estado invalido

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Consultar ordens de producao"
3. Introduzir um estado invalido para o qual se pretende consultar as ordens de producao
4. Submeter informacao
5. O sistema avisa o ator que introduziu um estado invalido

### Caso #3- Consultar uma ordem de producao em determinado estado vazio

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Consultar ordens de producao"
3. Introduzir um estado vazio para o qual se pretende consultar as ordens de producao
4. Submeter informacao
5. O sistema avisa o ator que introduziu um estado vazio

### Caso #4- Fazer pedido de consulta sem que existam ordens de producao registadas no sistema

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Consultar ordens de producao"
3. O sistema avisa o ator que nao existem ordens de producao registadas no sistema