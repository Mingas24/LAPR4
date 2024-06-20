# US2013 Aplicar transformacoes a um ficheiro XML anteriormente gerado pelo sistema
## Design

Utilizar a estrutura base da aplicacao baseada em camadas

- **Controlador** : TransformXMLController
- **UI** : XMLtoHTMLCompleteUI, XMLtoHTMLOnlyRawMatWithTechSheetUI, XMLtoHTMLUnityKGUI, XMLtoJSONCompleteUI, XMLtoTXTUnityKGCSVUI, XMLtoJSONProductsUI, XMLtoTXTCompleteUI, XMLtoTXTOnlyPLsWithMachinesUI, XMLtoJSONMachinesUI

## Padroes Usados

- Controller
  - Cria uma classe para manipular eventos do sistema correspondentes ao caso de uso.

## Sequence Diagram

![SD-US2013](.\SD-US2013.png)

Actor -> UI que coordena o UC dependendo da transformacao

## XSL Design

### HTML

- Representacao completa do chao de fabrica em diferentes tabelas
- Representacao dos produtos que tem como unidade o Kg
- Representacao das materias primas que tem ficha tecnica

### JSON

- Representacao completa do chao de fabrica
- Representacao dos produtos
- Representacao das maquinas

### TXT

- Representacao de todo o chao de fabrica em ficheiro CSV
- Representacao das production lines que contem maquinas
- Representacao dos produtos que tem como unidade o Kg

