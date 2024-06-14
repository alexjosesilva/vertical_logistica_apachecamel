
[![Latest Version](https://img.shields.io/github/v/release/alexjosesilva/vertical_logistica_apachecamel?include_prereleases)](https://github.com/alexjosesilva/vertical_logistica_apachecamel/releases/tag/0.5)
[![License](https://img.shields.io/github/license/alexjosesilva/vertical_logistica_apachecamel)]([https://github.com/seu-usuario/seu-repositorio/blob/master/LICENSE](https://github.com/alexjosesilva/vertical-logistica-java/blob/master/LICENSE))

# Projeto de Integração com Apache Camel

Este projeto é um exemplo de integração usando Apache Camel com Spring Boot. Ele lê um arquivo de texto contendo informações de pedidos, processa esses dados e retorna uma resposta em formato JSON.

## Requisitos

- Java 11 ou superior
- Apache Maven
- IDE (IntelliJ IDEA recomendada)
- Postman (para testes)
- Apache Camel
- Spring-boot

## Configuração do Projeto

### Passos para configurar o projeto na IDE IntelliJ

1. **Clonar o Repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. **Importar o Projeto no IntelliJ:**

3. **Abra o IntelliJ IDEA.**
- Selecione File > Open e escolha o diretório do projeto clonado.
- Configurar as Dependências:

4. **Certifique-se de que o Maven está configurado corretamente.**
- O IntelliJ deve baixar todas as dependências definidas no pom.xml automaticamente.
### Estrutura do Projeto
- src/main/java/com/example/camelintegration/Application.java: Classe principal do Spring Boot.
- src/main/java/com/example/camelintegration/route/PedidoRoute.java: Configuração das rotas Camel.
- src/main/java/com/example/camelintegration/processor/PedidoProcessor.java: Processador de pedidos.
- src/main/java/com/example/camelintegration/model/Pedido.java: Modelo de dados para os pedidos.

## Testando a API com Postman

1. Abrir o Postman.

2. Criar uma nova requisição POST:

- URL: http://localhost:8080/api/process
- Headers:
- Content-Type: text/plain
- Body (raw):
- Cole o conteúdo do arquivo data_1.txt.
3. Enviar a requisição e verificar a resposta:

- A resposta será um JSON com a estrutura normalizada dos pedidos.

## Exemplo de Arquivo
```
0000000002 Medeiros00000123450000000111 256.2420201201
0000000001 Zarelli00000001230000000111 512.2420211201
0000000001 Zarelli00000001230000000122 512.2420211201
0000000002 Medeiros00000123450000000122 256.2420201201
```

## Exemplo de Arquivo
```
[
    {
        "userId": 2,
        "name": "Medeiros",
        "orders": [
            {
                "orderId": 12345,
                "total": 512.48,
                "date": "Mon Dec 01 00:00:00 UTC 2020",
                "products": [
                    {
                        "productId": 111,
                        "value": 256.24
                    },
                    {
                        "productId": 122,
                        "value": 256.24
                    }
                ]
            }
        ]
    },
    {
        "userId": 1,
        "name": "Zarelli",
        "orders": [
            {
                "orderId": 123,
                "total": 1024.48,
                "date": "Wed Dec 01 00:00:00 UTC 2021",
                "products": [
                    {
                        "productId": 111,
                        "value": 512.24
                    },
                    {
                        "productId": 122,
                        "value": 512.24
                    }
                ]
            }
        ]
    }
]
```
