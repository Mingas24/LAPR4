# US 2010 - Introduzir Nova Ordem de Producao

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio :** ProductionOrder

- **Controlador :** IntroduceProductionOrderController
- **Repositorio:**  ProductionRepository



#### Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.



#### Diagrama de Sequencia



![US2010SD](.\US2010SD.png)