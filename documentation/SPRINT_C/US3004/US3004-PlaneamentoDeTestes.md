# US3004-Associar ficheiro de configuracao a uma determinada maquina

## Planeamento de Testes Unitarios a invariantes de negocio

### Machine:

- testSpecifyConfigurationFileWithInvalideMachine
- testSpecifyConfigurationFileWithInvalideFile



## Planeamento de testes funcionais e de Aceitacao

### Caso #1 - Associar ficheiro de configuracao a uma determinada maquina

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher a opcao "Especificar ficheiro de configuracao"
3. O sistema apresenta a lista de todas as maquinas disponiveis no sistema
4. Introduzir o ID da maquina e o nome do ficheiro
5. O sistema valida a informacao introduzida



### Caso #2 - Associar ficheiro de configuracao a uma determinada maquina sem que existam maquinas no sistema

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher a opcao "Especificar ficheiro de configuracao"
3. O sistema avisa o actor que nao existem maquinas disponiveis no sistema



### Caso #3 - Associar ficheiro de configuracao a uma determinada maquina que nao esteja no sistema

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher a opcao "Especificar ficheiro de configuracao"
3. O sistema apresenta a lista de todas as maquinas disponiveis no sistema
4. Introduzir o ID de uma maquina que nao esteja registada no sistema
5. O sistema avisa o actor que a maquina solicitada nao se encontra registada no sistema

### Caso #4 - Associar ficheiro de configuracao invalido a uma determinada maquina

1. Fazer login como Gestor de Chao de Fabrica
2. Escolher a opcao "Especificar ficheiro de configuracao"
3. O sistema apresenta a lista de todas as maquinas disponiveis no sistema
4. Introduzir o ID da maquina e o nome do ficheiro invalido
5. O sistema avisa o actor que ficheiro introduzido e invalido