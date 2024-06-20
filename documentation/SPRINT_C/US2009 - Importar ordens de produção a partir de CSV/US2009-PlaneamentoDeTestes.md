# US2009 Importar Ordens de Producao a Partir de CSV

## Planeamento de Testes Unitarios as invariantes de negocio

### Products:

- ensureproductionOrderIDMustNotBeNull
- ensureproductionOrderIDMustNotBeEmpty
- ensureproductionOrderIDIsUnique
- ensureEmissionDateMustNotBeNull
- ensureEmissionDateMustNotBeEmpty
- ensureExpectedExecutionDateMustNotBeNull
- ensureExpectedExecutionDateMustNotBeEmpty
- ensureExpectedExecutionDateIsNotBeforeEmissionDate

- ensureProductFabCodeMustNotBeNull
- ensureProductFabCodeMustNotBeEmpty
- ensureQuantityMustNotBeNull
- ensureQuantityMustNotBeEmpty
- ensureQuantityMustBePositive
- ensureUnityMustNotBeNull
- ensureUnityMustNotBeEmpty
- ensureOrderIDMustNotBeNull
- ensureOrderIDMustNotBeEmpty
- ensureStateMustNotBeNull
- ensureStateMustNotBeEmpty
- ensureCreatedExecutionOrderHasStatePending

## Plano de Testes Funcionais e de Aceitacao

### Caso#1 - Importar com sucesso

1. Fazer login como gestor de Producao
2. Escolher opcao "Importar ordens de producao"
3. Introduziu o nome do ficheiro
4. O sistema valida e informa o utilizador do sucesso da operacao

### Caso#2 - Importar sem o ficheiro

1. Fazer login como gestor de Producao
2. Escolher opcao "Importar ordens de producao"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que o ficheiro nao existe

### Caso#3 - Importar com erros no ficheiro

1. Fazer login como gestor de Producao
2. Escolher opcao "Importar ordens de producao"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que o ficheiro tem erros

### Caso#4 - Importar um ficheiro com informacao ja existente

1. Fazer login como gestor de Producao
2. Escolher opcao "Importar ordens de producao"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que as ordens de producao ja existem