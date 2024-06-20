# US3007-Consultar as notificacoes de erros de processamento arquivadas

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio :** ErrorNotification

- **Controlador :** ListFiledErrorNotificationsController
- **Repositorio:**  ErrorNotificationRepository



#### Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.
- DTO : e utilizado o padrao dto para nao mostrar diretamente as informacoes das notificacoes guardadas na base de dados, mas sim um copia das mesmas



#### Diagrama de Sequencia



![US3007SD](.\US3007SD.png)