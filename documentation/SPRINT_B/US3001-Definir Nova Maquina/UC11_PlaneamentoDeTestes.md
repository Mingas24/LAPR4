# UC11-Definir Nova Maquina

## Plano de Testes Unitarios

Machine:

- testCodeMustNotBeNullOrEmpty
- testDescriptionMustNotBeNullOrEmpty
- testBrandAndModelMustNotBeNullOrEmpty
- testSerialNumberMustNotBeNullOrEmpty
- testIntallationDateMustNotBeInTheFuture
- testMustBelongToAProductionLine

## Plano de Testes Funcionais

### Caso#1 - Adicionar uma nova Maquina

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher opcao "definir nova maquina"
3. Introduzir a informacao relativa a maquina (codigo, marca, modelo, tipo, numero de serie, data de instalacao, descricao e ficheiro de configuracao)
4. Submeter a informacao
5. O sistema valida e informa o utilizador do sucesso da operacao

### Caso#2 - Adicionar uma maquina sem codigo

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher opcao "definir nova maquina"
3. Nao introduz o codigo da maquina
4. Submeter a informacao
5. O sistema avisa o utilizador que o codigo nao foi definido

### Caso#3 - Adicionar uma maquina com codigo invalido

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher opcao "definir nova maquina"
3. Introduz um codigo de maquina invalido
4. Submeter a informacao
5. O sistema avisa o utilizador que o codigo e invalido

### Caso#4 - Adicionar uma maquina com codigo repetido

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher opcao "definir nova maquina"
3. Introduzir um codigo de maquina já existente
4. Submeter a informacao
5. O sistema avisa o utilizador que a maquina com aquele codigo ja existe
