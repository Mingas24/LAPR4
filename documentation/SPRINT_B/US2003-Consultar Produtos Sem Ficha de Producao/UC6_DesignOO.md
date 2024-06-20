# UC6-Consultar Produtos Sem Ficha De Producao

![](.\UC6_SD.jpg)

**Classes de Dominio:** Product

**DTO**: ProductDTO

**Service**: ListProductsServices

**UI**: ListProductsWithoutProductionSheetUI

**Controlador:** ListProductsWithoutProductionFileController

**Repositorio:** ProductRepository

## Padroes Usados

- Repository: Este padrao abstrai a persistencia numa classe repositorio que se comporta como uma lista

- Controller: Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos

- DTO: Este padrao permite a simplificacao/otimizacao da comunicação entre diferentes componentes de um sistema, agrupando um conjunto de atributos numa classe simples.

- Service: e usado para criar objetos servico que apenas tratam as operacoes e coordena os objectos de dominio necessarios.

  