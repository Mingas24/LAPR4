# UC9-Adicionar Produto ao Catalogo de Produtos

## Planeamento de Testes Unitarios as invariantes de negocio

### Produto:

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
- testAddProductWithoutShortDescription

## Planeamento de Testes Funcionais e de Aceitacao

### Caso #1 - Adicionar um novo Produto

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o identificador do produto,descricao completa, descricao breve,codigo comercial e o identificador da ficha de producao
4. Submeter a informacao
5. O sistema valida e informa o utilizador do sucesso da operacao

### Caso #2 - Adicionar um novo Produto com Identificador repetido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o identificador do produto ja existente ,descricao completa, descricao breve,codigo comercial e o identificador da ficha de producao
4. Submeter a informacao
5. O sistema avisa o utilizador que o produto com aquele identificador ja existe

### Caso #3 - Adicionar um novo Produto com Identificador invalido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o identificador do produto invalido ,descricao completa, descricao breve,codigo comercial e o identificador da ficha de producao
4. Submeter a informacao
5. O sistema avisa o utilizador que aquele identificador e invalido

### Caso #4 - Adicionar um novo Produto sem Identificador 

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir a descricao completa, descricao breve,codigo comercial e o identificador da ficha de producao sem definir o identificador do produto
4. Submeter a informacao
5. O sistema avisa o utilizador que o identificador do produto nao foi definido

### Caso #5 - Adicionar um novo Produto com Codigo Comercial repetido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o Codigo Comercial do produto ja existente ,descricao completa, descricao breve,identificador do produto  e o identificador da ficha de producao
4. Submeter a informacao
5. O sistema avisa o utilizador que o produto com aquele Codigo Comercial ja existe

### Caso #6 - Adicionar um novo Produto com Codigo Comercial invalido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o Codigo Comercial do produto invalido ,descricao completa, descricao breve,identificador do produto e o identificador da ficha de producao
4. Submeter a informacao
5. O sistema avisa o utilizador que aquele Codigo Comercial e invalido

### Caso #7 - Adicionar um novo Produto sem Codigo Comercial

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir a descricao completa, descricao breve,identificador do produto e o identificador da ficha de producao sem definir o Codigo Comercial
4. Submeter a informacao
5. O sistema avisa o utilizador que o Codigo Comercia do produto nao foi definido

### Caso #8 - Adicionar um novo Produto com identificador da ficha de producao repetido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o identificador da ficha de producao ja existente ,descricao completa, descricao breve,identificador do produto  e o codigo comercial
4. Submeter a informacao
5. O sistema avisa o utilizador que o produto com aquele identificador da ficha de producao ja existe

### Caso #9 - Adicionar um novo Produto com identificador da ficha de producao invalido

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir o identificador da ficha de producao invalido ,descricao completa, descricao breve,identificador do produto e o codigo comercial
4. Submeter a informacao
5. O sistema avisa o utilizador que aquele identificador da ficha de producao e invalido

### Caso #10 - Adicionar um novo Produto sem identificador da ficha de producao

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir a descricao completa, descricao breve,identificador do produto e o codigo comercial sem definir o identificador da ficha de producao
4. Submeter a informacao
5. O sistema avisa o utilizador que o identificador da ficha de producao do produto nao foi definido

### Caso #11 - Adicionar um novo Produto sem descricao completa

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir identificador da ficha de producao, descricao breve,identificador do produto e o codigo comercial sem definir a descricao completa
4. Submeter a informacao
5. O sistema avisa o utilizador que a descricao completa do produto nao foi definido

### Caso #12 - Adicionar um novo Produto sem descricao breve

1. Fazer login como gestor de projectos
2. Escolher opcao "adicionar novo produto"
3. Introduzir identificador da ficha de producao, descricao completa,identificador do produto e o codigo comercial sem definir a descricao breve
4. Submeter a informacao
5. O sistema avisa o utilizador que a descricao breve do produto nao foi definido