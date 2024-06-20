# UC6-Consultar Produtos Sem Ficha De Producao

## Plano de Testes Unitarios

ProductRepository:

- testProductRepositoryCanNotBeEmpty
- testThereIsNoProductWithoutProductionSheet

## Plano de Testes Funcionais

### Caso#1 - Apresentar Produtos sem Ficha de Producao

1. Fazer login como Gestor de Producao
2. Escolher opcao "Consultar Produtos Sem Ficha De Producao"
5. O sistema apresenta ao utilizador os produtos sem ficha de producao

### Caso#2 - Nao existem Produtos carregados

1. Fazer login como Gestor de Producao
2. Escolher opcao "Consultar Produtos Sem Ficha De Producao"
3. O sistema avisa o utilizador que nao exitem produtos carregados no sistema

### Caso#3 - Nao existem produtos sem ficha de producao

1. Fazer login como Gestor de Producao
2. Escolher opcao "Consultar Produtos Sem Ficha De Producao"
3. O sistema avisa o utilizador que nao exitem produtos sem ficha de producao no sistema
