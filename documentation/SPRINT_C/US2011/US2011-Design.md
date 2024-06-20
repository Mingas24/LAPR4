# US2011-Consultar Ordens de Producao em determinado estado



## Design

Utilizar a estrutura base da aplicacao baseada em camadas.



- **Classes de dominio:** ProductionOrder
- **Controlador**: ListProductionOrderController
- **Repositorio:** ProductionOrderRepository



## Padroes Usados

- **Controller**: recebe e processa os eventos gerados na UI

- **Repository**: cria uma abstracao da camada de dados, escondendo todos os detalhes de como o objecto e persistido 

- **DTO**: agrega informacoes da camada de aplicacao, sem revelar informacoes estruturais a camada de apresentacao

- **Factory**: define uma interface que permite a criação de objectos, deixando a subclasse decidir que classes instanciar 

- **Service**: define um set de operacoes que pode ser utilizado por outras camadas

  



## Sequence Diagram

![SD-US2011](.\SD-US2011.jpg)