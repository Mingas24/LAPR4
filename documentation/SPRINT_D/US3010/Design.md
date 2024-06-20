# US3010-Solicitar o envio de uma determinada configuracao para uma maquina



## Design

Utilizar a estrutura da aplicacao baseada em camadas

- UI: RequestConfigUI

- Controller: SpecifyConfigurationFileController
- Repository: RequestFileRepository

## Padroes utilizados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista 
- Controller: Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso

## Sequence Diagram



![SD](.\SD_US3010.jpg)

