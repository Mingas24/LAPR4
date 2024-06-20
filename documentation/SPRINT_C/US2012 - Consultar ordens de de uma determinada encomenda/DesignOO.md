# US2012 - Consultar ordens de de uma determinada encomenda

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- Classes do Dominio : ProductionOrder
- DTO: ProductionOrderDTO
- Service:  ListProductionOrderServices
- UI: ListProductionOrderByIDUI
- Controlador :ListProductionOrderByID
- Repositorio :ProductionOrderRepository

### Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Service: e usado para criar objetos servico que apenas tratam as operacoes e coordena os objectos de dominio necessarios.
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.
- DTO: Este padrao permite a simplificacao/otimizacao da comunicação entre diferentes componentes de um sistema, agrupando um conjunto de atributos numa classe simples.

### Diagrama de Sequencia![US2012](C:\lei_isep_2019_20_sem4_2dh_1160867_1180954_1180990_1181069_1181\documentation\SPRINT_C\US2012 - Consultar ordens de de uma determinada encomenda\US2012.png)