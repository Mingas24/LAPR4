# UC2 - Adicionar Materia-Prima

## Planeamento de Testes Unitarios a invariantes de negocio

### RawMaterial:

- testAddRawMaterialWithRepeteadInternalCode
- testAddRawMaterialWithInvalidInternalCode
- testAddRawMaterialWithInvalidCategoryId
- testAddRawMaterialWithEmptyCategoryId
- testAddRawMaterialWithEmptyDescription
- testAddRawMaterialWithIvalidMaterial
- testAddRawMaterialWithEmptyMaterial
- testAddRawMaterialWithIvalidProduct
- testAddRawMaterialWithEmptyProduct



## Planeamento de testes funcionais e de Aceitacao

### Caso #1 - Adicionar nova Materia-Prima

1. Fazer login como gestor de producao
2. Escolher opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, identificador de categoria, ficha tecnica, descricao da materia-prima e material ou produto
4. Submeter informacao
5. O sistema valida e informa o utilizador do sucesso da operacao

### Caso #2 - Adicionar uma nova Materia-Prima com codigo interno repetido

1. Fazer login como gestor de producao.
2. Escolher opcao "adicionar nova materia-prima"
3. Introduz um codigo interno ja existente, categoria, ficha tecnica, descricao da materia-prima e material ou produto.
4. Submeter a informacao
5. O sistema avisa o utilizador que a materia-prima com aquele codigo interno já existe no sistema.

### Caso #3 - Adicionar uma nova Materia-Prima com codigo interno invalido

1. Fazer login como gestor de producao
2. Escolher opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno da materia-prima invalido, categoria, ficha tecnica, descricao da materia-prima e material ou produto.
4. Submeter informacao
5. O sistema avisa o utilizador que aquele codigo codigo interno e invalido.

### Caso #4 - Adicionar uma nova Materia-Prima com uma categoria invalida

1. Fazer login como gestor de producao
2. Escolher a opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, categoria invalida, ficha tecnica, descricao da materia-prima e material ou produto.
4. Submeter informacao
5. O sistema avisa o utilizador que aquela categoria e invalida

### Caso #5 - Adicionar uma nova Materia-Prima com uma categoria inexistente

1. Fazer login como gestor de producao
2. Escolher a opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, não introduz categoria, ficha tecnica, descricao da materia-prima e material ou produto.
4. Submeter informacao
5. O sistema avisa o utilizador que categoria e inexistente

### Caso #6 - Adicionar uma nova Materia-Prima sem descricao

1. Fazer login como gestor de producao
2. Escolher a opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, categoria, ficha tecnica, sem definir descricao da materia-prima e material ou produto.  
4. Submeter informacao
5. O sistema avisa o utilizador que a descricao da materia-prima nao foi definida

### Caso #7 - Adicionar nova Materia-Prima com produto ou material invalido

1. Fazer login como gestor de producao
2. Escolher opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, categoria, ficha tecnica, descricao da materia-prima e material ou produto invalido
4. Submeter informacao
5. O sistema avisa o utilizador que o material ou o produto introduzidos sao invalidos

### Caso #8 - Adicionar nova Materia-Prima com produto ou material inexistente

1. Fazer login como gestor de producao
2. Escolher opcao "adicionar nova materia-prima"
3. Introduzir o codigo interno, categoria, ficha tecnica, descricao da materia-prima e material ou produto inexistente
4. Submeter informacao
5. O sistema valida e informa o utilizador que o material ou o produto nao foram introduzidos





































