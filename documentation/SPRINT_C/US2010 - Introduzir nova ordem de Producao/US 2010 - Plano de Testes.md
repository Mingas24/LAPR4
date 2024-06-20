# US 2010 - Introduzir Nova Ordem de Producao 



## Testes Unitarios para as invariantes do sistema

#### Ordem de Producao

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



### Caso #1 - Introduzir uma nova ordem de producao

1. Fazer login como gestor de producao

2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas.

4. submeter a informacao

5. o sistema valida e informa o utilizador do sucesso da operacao

   

### Caso #2 - Introduzir um identificador de ordem repetido

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"

3. Introduzir um identificador da ordem de producao que ja exista, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas.
4. submeter a informacao
5. o sistema avisa o utilizador que ja existe uma ordem de producao com identificador inserido



### Caso #3 - Introduzir uma ordem de producao sem identificador

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"

3. Introduzir a data de emissao da ordem de producao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas, nao introduzindo um identificador para a ordem de producao
4. submeter a informacao
5. o sistema avisa o utilizador que o identificador da ordem de producao nao foi inserido



### Caso #4 - Introduzir uma ordem de producao sem data de emissao

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao,  a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas, nao introduzindo a data de emissao da ordem de producao
4. submeter a informacao
5. o sistema avisa o utilizador que nao foi definida a data de emissao da ordem de producao



### Caso #5 - Introduzir uma ordem de producao sem data prevista de execucao

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas, nao introduzindo a data prevista de execucao
4. submeter a informação
5. o sistema avisa o utilizador que nao foi definida a data prevista de execucao da ordem de producao



### Caso #6 - Introduzir uma data prevista de execucao invalida

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"
3. Introduzir o identificador da ordem de producao, a data da sua emissao, uma data prevista de execucao anterior a data de emissao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas.
4. submeter a informacao
5. o sistema avisa o utilizador que a data prevista de execucao inserida nao e valida



### Caso #7 - Introduzir uma ordem de producao sem o codigo do produto a ser produzido

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"
3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas, nao inserindo o codigo de fabrico do produto.
4. submeter a informacao
5. o sistema avisa o utilizador que nao foi introduzido o codigo de fabrico do produto.



### Caso #8 - Introduzir um codigo de fabrico de um produto inexistente

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"
3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, um codigo de fabrico que nao corresponda a nenhum produto, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas.
4. submeter a informacao
5. o sistema avisa o utilizador que o produto com o codigo de fabrico inserido nao existe



### Caso #9 - Introduzir um codigo de fabrico de um produto sem ficha de producao

1. Fazer login como gestor de producao

2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir mas que ainda nao tem uma ficha de producao definida, a quantidade a ser produzida, a unidade de medida e um ou varios identicadores de encomendas.

4. submeter a informacao

5. o sistema valida e guarda a informacao, informando o utilizador do sucesso da operacao mas avisa que o produto inserido ainda nao tem uma ficha de producao definida.

   

### Caso #10 - Introduzir uma ordem de producao sem definir a quantidade

1. Fazer login como gestor de producao

2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a unidade de medida e um ou varios identicadores de encomendas, nao referindo a quantidade a ser produzida.

4. submeter a informacao

5. o sistema avisa o utilizador que nao foi definida a quantidade a ser produzida.

   

### Caso #11 - Introduzir uma quantidade nao positiva

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"
3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, uma quantidade igual ou inferior a 0, a unidade de medida e um ou varios identicadores de encomendas.
4. submeter a informacao
5. o sistema avisa o utilizador que a quantidade introduzida nao e valida.



### Caso #12 - Introduzir uma ordem de producao sem unidade de medida

1. Fazer login como gestor de producao

2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida e um ou varios identicadores de encomendas, nao referindo a unidade de medida em que vai ser feita a producao.

4. submeter a informacao

5. o sistema avisa o utilizador que nao foi definida a unidade de medida na qual vai ser feita a producao

   

### Caso #13 - Introduzir uma unidade de medida invalida

1. Fazer login como gestor de producao
2. Escolher opcao "introduzir ordem de producao"
3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, uma unidade de medida diferente das definidas no sistema e um ou varios identicadores de encomendas.
4. submeter a informacao
5. o sistema avisa o utilizador que a unidade de medida introduzida nao e valida



### Caso #14 - Introduzir nova ordem de producao sem inserir nenhum identificador da encomenda

1. Fazer login como gestor de producao

2. Escolher opcao "introduzir ordem de producao"

3. Introduzir o identificador da ordem de producao, a data da sua emissao, a data prevista da sua execucao, o codigo de fabrico correspondente ao produto que ira produzir, a quantidade a ser produzida, a unidade de medida nao inserindo nenhum identicador de encomenda.

4. submeter a informacao

5. o sistema avisa o utilizador que nao foi inserido nenhum identificador da encomenda