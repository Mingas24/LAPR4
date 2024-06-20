# US5001-Processar mensagens disponíveis no sistema

Utilizar a estrutura base da aplicacao baseada em camadas

- UI : ProcessMessageUI
- Controller : ProcessMessageController
- Domain : 
  - Message
  - ListProductionLines
- Repository: 
  - MessageRepository
  - ProductionLineRepository	

### Padrões utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso

### Diagrama de Sequencia

![SD_US5001](.\SD_US5001.png)