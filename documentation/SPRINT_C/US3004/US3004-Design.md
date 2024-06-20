# US3004-Associar Ficheiro de configuracao para uma determinada maquina

## Design

Utilizar a estrutura base da aplicacao baseada em camadas.



- **Classes de dominio:** Machine
- **Controlador**: SpecifyConfigurationFileController
- **Repositorio:** MachineRepository



## Padroes Usados

- **Controller**: recebe e processa os eventos gerados na UI

- **Repository**: cria uma abstracao da camada de dados, escondendo todos os detalhes de como o objecto e persistido 

- **DTO**: agrega informacoes da camada de aplicacao, sem revelar informacoes estruturais a camada de apresentacao

- **Factory**: define uma interface que permite a criação de objectos, deixando a subclasse decidir que classes instanciar 

- **Service**: define um set de operacoes que pode ser utilizado por outras camadas



## Sequence Diagram 

## ![SD-US3004](.\SD-US3004.jpg)

