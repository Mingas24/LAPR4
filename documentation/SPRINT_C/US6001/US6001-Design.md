# US6001-Monitorizar estado das maquinas por linha de producao



## Design:

Utilizar a estrutura da aplicacao baseada em camadas

**Factory**: RepositoryFactory

**Repository**: ProductionLineRepository, MachineRepository



## Padroes Usados

- **Factory**: define uma interface que permite a criação de objectos, deixando a subclasse decidir que classes instanciar 
- **Repository**: cria uma abstracao da camada de dados, escondendo todos os detalhes de como o objecto e persistido 



## Sequence Diagram

![SD-US6001](.\US6001-SD.jpg)





