# UC4-Adicionar Categorias de Materias-Primas

## Plano de Testes Unitarios as invariantes de negocio

### Categoria:

- testAddProductWithRepeteadCategoryID
- testAddProductWithInvalidCategoryID
- testAddProductWithoutCategoryID

## Planeamento de Testes Funcionais e de Aceitacao

### Caso#1 - Adicionar uma nova Categoria

1. Fazer login como gestor de Projecto
2. Escolher opcao "adicionar nova categoria"
3. Introduzir o identificador da categoria
4. Submeter a informacao
5. O sistema valida e informa o utilizador do sucesso da operacao

### Caso#2 - Adicionar uma categoria sem identificador

1. Fazer login como gestor de Projecto
2. Escolher opcao "adicionar nova categoria"
3. Nao introduz o identificador da categoria
4. Submeter a informacao
5. O sistema avisa o utilizador que o identificador nao foi definido

### Caso#3 - Adicionar uma categoria com identificador invalido

1. Fazer login como gestor de Projecto
2. Escolher opcao "adicionar nova categoria"
3. Introduz um o identificador da categoria invalido
4. Submeter a informacao
5. O sistema avisa o utilizador que o identificador e invalido

### Caso#4 - Adicionar uma categoria com identificador repetido

1. Fazer login como gestor de Projecto
2. Escolher opcao "adicionar nova categoria"
3. Introduzir um o identificador de categoria já existente
4. Submeter a informacao
5. O sistema avisa o utilizador que a categoria com aquele identificador ja existe





