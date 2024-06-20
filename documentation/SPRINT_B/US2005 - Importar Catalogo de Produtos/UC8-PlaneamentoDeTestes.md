# UC8 - Importar Catalogo de Produtos

## Planeamento de Testes Unitarios as invariantes de negocio

### Products:

- testAddProductWithRepeteadProductID
- testAddProductWithInvalidProductID
- testAddProductWithoutProductID
- testAddProductWithRepeteadComercialCode
- testAddProductWithInvalidComercialCode
- testAddProductWithoutComercialCode
- testAddProductWithRepeteadProductionSheetID
- testAddProductWithInvalidProductionSheetID
- testAddProductWithoutProductionSheetID
- testAddProductWithoutCompletedDescription

## Plano de Testes Funcionais e de Aceitacao

### Caso#1 - Importar com sucesso

1. Fazer login como gestor de Projecto
2. Escolher opcao "Importar Catalogo de Produtos"
3. Introduziu o nome do ficheiro
4. O sistema valida e informa o utilizador do sucesso da operacao

### Caso#2 - Importar sem o ficheiro

1. Fazer login como gestor de Projecto
2. Escolher opcao "Importar Catalogo de Produtos"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que o ficheiro nao existe

### Caso#3 - Importar com erros no ficheiro

1. Fazer login como gestor de Projecto
2. Escolher opcao "Importar Catalogo de Produtos"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que o ficheiro tem erros

### Caso#4 - Importar um ficheiro com informacao ja existente

1. Fazer login como gestor de Projecto
2. Escolher opcao "Importar Catalogo de Produtos"
3. Introduziu o nome do ficheiro
4. O sistema avisa o utilizador que a o catalogo ja existe