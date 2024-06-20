# UC13 - Definir nova Linha de Producao

## Planeamento de Testes Unitarios as invariantes de negocio

### Produto:

- testAddLineWithInvalidMachines
- testAddLineWithNoMachines
- testAddLineWithMachinesThatDoNotExist

## Planeamento de Testes Funcionais e de Aceitacao

### Caso#1 - Definiu com sucesso

1. Fazer login como gestor de Projecto
2. Escolher opcao "Definir nova linha de producao"
3. Introduziu as maquinas que quer nessa linha de producao
4. O sistema valida e informa o utilizador do sucesso da operacao

### Caso#2 - Tentou definir uma linha com maquinas inexistentes

1. Fazer login como gestor de Projecto
2. Escolher opcao "Definir nova linha de producao"
3. Introduziu maquinas que nao existem no sistema
4. O sistema avisa o utilizador que uma ou mais das maquinas selecionadas nao existe

### Caso#3 - Tentou definir uma linha com maquinas que ja estao numa linha de producao

1. Fazer login como gestor de Projecto
2. Escolher opcao "Definir nova linha de producao""
3. Introduziu maquinas que ja estao numa linha de producao
4. O sistema avisa o utilizador que uma ou mais maquinas ja pertencem a uma linha de producao

### Caso#4 - Tentou definir uma linha de producao sem maquinas

1. Fazer login como gestor de Projecto
2. Escolher opcao "Definir nova linha de producao"
3. Nao introduziu nenhuma maquina para adicionar a linha de producao
4. O sistema avisa o utilizador que nao colocou nomes de maquinas