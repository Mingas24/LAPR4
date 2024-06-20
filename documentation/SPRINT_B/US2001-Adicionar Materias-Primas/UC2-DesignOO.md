# UC2-Adicionar Materias-Primas



## Design

Utilizar a estrutura base da aplicacao baseada em camadas



- **Classes de dominio:**  RawMaterial
- **Controlador:** AddRawMaterialController
- **Repositorio:** RawMaterialRepository

## Padroes Usados

- Repository: O padrao repository e usado quando se pretende aceder a base de dados, neste caso para guardar o objecto criado.
- Controller: Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos
- DTO: Este padrao permite a simplificacao/otimizacao da comunicação entre diferentes componentes de um sistema, agrupando um conjunto de atributos numa classe simples.
- Service: e usado para criar objetos servico que apenas tratam as operacoes e coordena os objectos de dominio necessarios.

## Sequence Diagram

![UC2_SD](.\UC2-SD.jpg)





