# UC14-Inicializar Depositos [BOOT]

## Sequence Diagram![UC14_SD](C:\lei_isep_2019_20_sem4_2dh_1160867_1180954_1180990_1181069_1181\documentation\UC14-Inicializar Depositos [BOOT]\UC14_SD.jpg)

## Padroes Usados

- Service
  - O padrao Service e usado para criar objetos servico que apenas tratam as operacoes e coordena os objectos de dominio necessarios.
- Repository
  - O padrao repository e usado quando se pretende aceder a base de dados, neste caso para guardar o objecto criado.
- Controller
  - Cria uma API que permite responder aos casos de uso da aplicacao atraves da coordenacao de outros objetos

## Design

Utilizar a estrutura base da aplicacao baseada em camadas

- **Classes de dominio:**  Deposit,DepositType,DepositDescription,DepositID
- **Controlador:** DefineDepositController
- **Repositorio:** DepositRepository