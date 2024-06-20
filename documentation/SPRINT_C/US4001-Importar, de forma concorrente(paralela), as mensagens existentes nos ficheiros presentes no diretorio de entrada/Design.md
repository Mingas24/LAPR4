# US4001-Importar, de forma concorrente/paralela, as mensagens existentes nos ficheiros presentes no diretorio de entrada

## Design

Utilizar a estrutura base da aplicacao baseada em camadas.

- **Classes** : ImportService, ThreadService, Interperter
- **Controller** : MessageController
- **UI** : ImportServiceUI
- **Repositories** : MessageRepository

## Padroes Usados

- Controller
  - Cria uma classe para manipular os eventos do sistema em relacao a este caso de uso

## Sequence Diagram

![SD_US4001](.\SD_US4001.jpg)