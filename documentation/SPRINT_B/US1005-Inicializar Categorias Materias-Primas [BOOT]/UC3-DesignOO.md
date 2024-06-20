# UC3-Inicializar Categorias Materias-Primas [BOOT]

## Sequence Diagram

![SD-UC3](.\SD-UC3.jpg)

## Design

Utilizar a estrutura de base da aplicacao baseada em camadas

- **Classes do Dominio** : Category
- **Controller** : AddCategoryController
- **Bootstrap** : CategoriesBOOT 

## Padroes Usados

- Factory 
  - O padrao factory e usado para encapsular a criacao de objectos, neste caso objectos do tipo categoria.
- Controller
  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos