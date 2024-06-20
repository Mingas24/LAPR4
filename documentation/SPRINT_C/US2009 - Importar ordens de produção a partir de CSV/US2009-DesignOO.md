# US2009 Importar Ordens de Producao a Partir de CSV
## Design

Utilizar a estrutura base da aplicacao baseada em camadas

- **Classes do dominio** : ImportCSV, ImportProductionOrders
- **Controlador** : ImportProductionOrders, IntroduceProductionOrderController
- **UI** : ImportProductionOrdersUI

## Padroes Usados

- Repository
  - Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller
  - Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.

## Sequence Diagram

![SD-US2009](.\SD-US2009.png)