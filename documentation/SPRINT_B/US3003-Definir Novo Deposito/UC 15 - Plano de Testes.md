# UC 15 - Definir Novo Deposito



## Testes Unitarios para as invariantes do sistema

#### Deposito

- testDepositIDMustNotBeNull
- testDepositIDMustNotBeEmpty
- ensureDepositIDIsUnique
- ensureDepositIdIsLessThan10Characters
- testDepositTypeMustNotBeNull
- testDepositTypeMustNotBeEmpty
- ensureDepositTypeIsInOrOut
- testDescriptDepositMustNotBeNull
- testDescriptDepositMustNotBeEmpty



## Plano de Testes Funcionais e de Aceitacao



### Caso #1 - Definir um novo deposito

1. Fazer login como gestor de chao de fabrica

2. Escolher opcao "definir novo deposito"

3. Introduzir o identificador do deposito, o tipo de deposito (entrada ou saida) e a descricao

4. submeter a informacao

5. o sistema valida e informa o utilizador do sucesso da operacao

   

### Caso #2 - Definir um deposito com tipo invalido

1. Fazer login como gestor de chao de fabrica
2. Escolher opcao "definir novo deposito"
3. Introduzir o identificador do deposito, um tipo de deposito diferente de "entrada" ou "saida" e a descricao
4. submeter a informacao
5. o sistema avisa o utilizador que o tipo de deposito inserido não e valido



### Caso #3 - Definir um deposito sem descricao

1. Fazer login como gestor de chao de fabrica
2. Escolher opcao "definir novo deposito"
3. Introduzir o identificador do deposito e um tipo de deposito, nao preenchendo a descricao
4. submeter a informacao
5. o sistema avisa o utilizador que o parametro descricao não foi preenchido



### Caso #4 - Definir um deposito sem tipo de deposito

1. Fazer login como gestor de chao de fabrica
2. Escolher opcao "definir novo deposito"
3. Introduzir o identificador do deposito e a descricao do deposito, nao identificando o tipo de deposito
4. submeter a informacao
5. o sistema avisa o utilizador que o tipo de deposito nao foi definido



### Caso #5 - Definir um deposito com identificador repetido

1. Fazer login como gestor de chao de fabrica
2. Escolher opcao "definir novo deposito"
3. Introduzir um identificador de um deposito ja existente, uma descricao e identificar um tipo de deposito
4. submeter a informação
5. o sistema avisa o utilizador que o deposito com aquele identificador ja existe



### Caso #6 - Definir um deposito sem identificador

1. Fazer login como gestor de chao de fabrica
2. Escolher opcao "definir novo deposito"
3. Introduzir a descricao do deposito e identificar o tipo de deposito, sem definir um identificador para o mesmo
4. submeter a informacao
5. o sistema avisa o utilizador que o identificador do deposito nao foi definido