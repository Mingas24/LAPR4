# US2009 Importar Ordens de Producao a Partir de CSV

## Plano de Testes Funcionais e de Aceitacao

### Caso#1 - Exportar com sucesso

1. Fazer login como gestor de Producao
2. Escolher opcao "Exportar para ficheiro XML"
3. Escolher "Exportar toda a informacao do chao de fabrica"
4. O sistema exporta a infomacao com sucesso

### Caso#2 - Exportar com falta de informacao

1. Fazer login como gestor de Producao
2. Escolher opcao "Exportar para ficheiro XML"
3. Escolher "Exportar toda a informacao do chao de fabrica"
4. O sistema falha a exportacao

### Caso#3 - Exportar com erros na informacao

1. Fazer login como gestor de Producao
2. Escolher opcao "Exportar para ficheiro XML"
3. Escolher "Exportar toda a informacao do chao de fabrica"
4. O sistema exporta mas o XSD invalida o ficheiro
