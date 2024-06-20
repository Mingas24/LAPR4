# UC4-Adicionar Categorias de Materias-Primas

## Sequence Diagram

![UC4_SD](C:.\UC4_SD.jpg)

## Padroes Usados

- Factory 
  - O padrao factory e usado para encapsular a criacao de objectos, neste caso objectos do tipo categoria.
- Repository
  - O padrao repository e usado quando se pretende aceder a base de dados, neste caso para guardar o objecto criado.
- Controller
  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos

## Design

Utilizar a estrutura base da aplicacao baseada em camadas

- **Classes de dominio:**  Category,CategoryID,CategoryDescription
- **Controlador:** AddCategoryController
- **Repositorio:** CategoryRepository