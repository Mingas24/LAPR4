# US3006-Arquivar uma ou mais notificacoes de erros de processamento

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio :** ErrorNotification

- **Controlador :** FileErrorNotificationController
- **Repositorio:**  ErrorNotificationRepository



#### Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.



#### Diagrama de Sequencia



![US3006SD](.\US3006SD.png)