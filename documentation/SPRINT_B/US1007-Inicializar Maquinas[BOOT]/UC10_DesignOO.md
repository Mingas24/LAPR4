# UC 10 - Inicializar Maquinas[BOOT]

![BootstrapMaquinaSD](.\BootstrapMaquinaSD.png)

## Design

Utilizar a estrutura da aplicacao baseada em camadas, fazendo uso do controlador responsavel por criar maquinas de modo a evitar a duplicacao de codigo.



**Bootstrapper:** MachineBootstrapper

**Controlador:** MachineController



#### Padroes Utilizados

- Factory: utilizado para encapsular a criacao de objetos, neste casos objetos do tipo maquina.
- Repository: utilizado quando se pretende aceder a base de dados, neste caso para guardar o objeto criado.

