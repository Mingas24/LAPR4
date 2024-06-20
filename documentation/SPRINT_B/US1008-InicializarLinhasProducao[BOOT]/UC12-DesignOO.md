# UC12-Inicializar Linhas de Produção [BOOT]



## Design

Utilizar a estrutura da aplicacao baseada em camadas, fazendo uso do controlador responsavel por criar linhas de producao, de modo a evitar a duplicacao de codigo.



**Classe de Dominio:** ProductionLine

**Bootstrapper:** BootstrapperProductLine

**Controlador:** ProductLineController



### Padroes Utilizados

- Controller: cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos



## Sequence Diagram

![UC12_SD](.\UC12 - SD.jpg)