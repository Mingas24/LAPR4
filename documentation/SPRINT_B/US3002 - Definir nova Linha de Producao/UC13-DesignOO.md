# UC13 - Definir nova Linha de Producao

## Sequence Diagram

![SD-UC13](.\SD-UC13.jpg)

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio :** ProductionLine
- **Controlador :** ProductionLineController
- **Repositorio:**  RepositoryFactory, PersistanceContext, MachineRepository, ProductionLineRepository
- **UI** : ProductionLineUI

## Padroes Usados

- Factory 
  
  - O padrao factory e usado para encapsular a criacao de objectos, neste caso objectos do tipo linha de producao.
  
- Repository

  - O padrao repository e usado quando se pretende aceder a base de dados, neste caso para guardar o objecto criado

- Controller

  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos

    