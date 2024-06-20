# US1011-Desenvolver uma aplicacao que simule o funcionamento de uma maquina

## Plano de Testes Funcionais e de Aceitacao

### Caso #1 - Simular a mensagem duma maquina

1. O simulador e executado
3. Introduzir o ip, o id do protocolo e a cadencia
4. submeter a informacao
5. o sistema valida e executa a simulacao

### Caso #2 -Simular a mensagem duma maquina sem o ip

1. O simulador e executado
2. Introduzir o id do protocolo e a cadencia mas nao o ip
3. submeter a informacao
4. o sistema avisa o utilizador do erro

### Caso #3 -Simular a mensagem duma maquina sem o id do protocolo

1. O simulador e executado
2. Introduzir o ip e a cadencia mas nao o id do protocolo
3. submeter a informacao
4. o sistema avisa o utilizador do erro

### Caso #4 -Simular a mensagem duma maquina com o id do protocolo inexistente

1. O simulador e executado
2. Introduzir o ip e a cadencia mas o id do protocolo inexistente
3. submeter a informacao
4. o sistema avisa o utilizador do erro

### Caso #5 - Simular a mensagem duma maquina sem o id do protocolo

1. O simulador e executado
2. Introduzir o ip e o id do protocolo mas nao a cadencia
3. submeter a informacao
4. o sistema avisa o utilizador do erro