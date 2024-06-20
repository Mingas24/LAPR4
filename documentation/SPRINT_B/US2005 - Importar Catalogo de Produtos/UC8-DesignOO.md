# UC8-Importar Catalogo de Produtos

## Sequence Diagram

![SD-UC8](.\SD-UC8.png)

## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes do dominio** : ImportCSV, ImportProductCatalogue
- **Controlador** : ImportProductCatalogueController, AddProductController
- **UI** : ImportProductCatalogueUI

## Padroes Usados

- Factory 
  - O padrao factory e usado para encapsular a criacao de objectos, neste caso objectos do tipo produto.
- Controller
  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos