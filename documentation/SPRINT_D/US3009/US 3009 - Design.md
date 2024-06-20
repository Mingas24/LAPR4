# US3009 - Saber e alterar o estado do processamento de mensagens e conhecer a ultima vez que o mesmo se realizou

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio :** ProductionLine

- **Controlador :**  ChangeProcessmentStateController
- **Repositorio:**  ProductionLineRepository



#### Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.



#### Diagrama de Sequencia



![US3009SD](.\US3009SD.png)