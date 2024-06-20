# UC7 - Especificar Ficha de Producao para um dado Produto

## Planeamento de testes unitarios a invariantes de negocio

### Product

- testAddProductionSheetWithInvalidRawMaterialQuantity
- testAddProductionSheetWithEmptyRawMaterialQuantity
- testAddProductionSheetWithInvalidProductQuantity
- testAddProductionSheetWithEmptyProductQuantity
- testAddProductionSheetWithInvalidComercialCode
- testAddProductionSheetWithEmptyComercialCode

## Planeamento de testes funcionais e de Aceitacao

### Caso #1 - Especificar nova Ficha de Producao

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima, quantidade de produto e codigo comercial do produto
4. Submeter a informacao
5. O sistema valida e informa o utilizador do sucesso da operacao

### Caso #2 - Especificar nova Ficha de Producao com quantidade de materia-prima invalida

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima invalida, quantidade de produto e codigo comercial do produto
4. Submeter a informacao
5. O sistema valida e informa o utilizador que a quantidade de materia-prima e invalida

### Caso #3 - Especificar nova Ficha de Producao com quantidade de materia-prima inexistente

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima inexistente, quantidade de produto e codigo comercial do produto
4. Submeter a informacao
5. O sistema valida e informa o utilizador que a quantidade de materia-prima e inexistente

### Caso #4 - Especificar nova Ficha de Producao com quantidade de produto invalida

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima, quantidade de produto invalida e codigo comercial do produto
4. Submeter a informacao
5. O sistema valida e informa o utilizador que a quantidade de produto e invalida

### Caso #5 - Especificar nova Ficha de Producao com quantidade de produto inexistente

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima, quantidade de produto inexistente e codigo comercial do produto
4. Submeter a informacao
5. O sistema valida e informa o utilizador que a quantidade de produto e inexistente

### Caso #6 - Especificar nova Ficha de Producao com codigo comercial invalido

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima, quantidade de produto, codigo comercial do produto invalido
4. Submeter a informacao
5. O sistema valida e informa o utilizador que o codigo comercial do produto invalido

### Caso #7 - Especificar nova Ficha de Producao com codigo comercial inexistente

1. Fazer login como Gestor de Producao
2. Escolher a opcao "Especificar nova Ficha de Producao"
3. Introduzir quantidade de materia-prima, quantidade de produto, codigo comercial do produto inexistente
4. Submeter a informacao
5. O sistema valida e informa o utilizador que o codigo comercial do produto e inexistente