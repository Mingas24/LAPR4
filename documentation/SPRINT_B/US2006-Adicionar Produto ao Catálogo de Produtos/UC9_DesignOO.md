# UC9-Adicionar Produto ao Catálogo de Produtos

## Sequence Diagram

# ![UC9_SD](C:\lei_isep_2019_20_sem4_2dh_1160867_1180954_1180990_1181069_1181\documentation\UC9-Adicionar Produto ao Catálogo de Produtos\UC9_SD.png)

## Padroes Usados

- Factory 
  - O padrao factory e usado para encapsular a criacao de objectos, neste caso objectos do tipo produto.
-  Repository
  - O padrao repository e usado quando se pretende aceder a base de dados, neste caso para guardar o objecto criado.
- Controller
  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos

## Design

Utilizar a estrutura base da aplicacao baseada em camadas

- **Classes de dominio:**  Product,ComercialCode,CompleteDescription,ProductSheet,ShortDescription,UniqueFabricationCode
- **Controlador:** AddProductController
- **Repositorio:** ProductRepository