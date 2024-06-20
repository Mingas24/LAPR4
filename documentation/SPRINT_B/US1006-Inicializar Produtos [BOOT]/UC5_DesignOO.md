# UC 5 - Inicializar Produtos [BOOT]

![BootstrapProdutoSD](.\BootstrapProdutoSD.png)

## Design

Utilizar a estrutura da aplicacao baseada em camadas, fazendo uso do controlador responsavel por criar produtos de modo a evitar a duplicacao de codigo.



**Bootstrapper:** ProductBootstrapper

**Controlador:** addProductControler



#### Padroes Utilizados

- Factory: utilizado para encapsular a criacao de objetos, neste casos objetos do tipo produto.
- Repository: utilizado quando se pretende aceder a base de dados, neste caso para guardar o objeto criado.

