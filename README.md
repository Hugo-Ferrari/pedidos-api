# Pedidos API

API REST para gerenciamento de pedidos desenvolvida com Java e Spring Boot.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI 3)
- Maven
- Lombok

## Funcionalidades

- Cadastro e login de usuários
- CRUD completo de produtos
- Soft delete de produtos e usuários
- Sistema de pedidos com múltiplos itens
- Cálculo automático do total do pedido
- Preço capturado no momento da compra
- Documentação automática com Swagger

## Como rodar localmente

### Pré-requisitos
- Java 21+
- Maven
- PostgreSQL instalado e rodando

### Configuração do banco de dados

Crie um banco de dados no PostgreSQL:
   CREATE DATABASE pedidos_api;

Configure as credenciais no arquivo src/main/resources/application.yml:
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/pedidos-api
       username: postgres
       password: sua_senha

### Passos

1. Clone o repositório
   git clone https://github.com/Hugo-Ferrari/pedidos-api.git

2. Entre na pasta
   cd pedidos-api

3. Configure o banco de dados conforme instruções acima

4. Rode o projeto
   ./mvnw spring-boot:run

5. Acesse a documentação
   http://localhost:8080/swagger-ui/index.html

## Endpoints

### Usuários
- POST /users/auth/register — cadastrar usuário
- POST /users/auth/login — login
- GET /users — listar usuários
- DELETE /users/{id} — deletar usuário (soft delete)

### Produtos
- POST /products — criar produto
- GET /products — listar produtos ativos
- PUT /products/{id} — atualizar produto completo
- PATCH /products/{id} — atualizar produto parcialmente
- DELETE /products/{id} — deletar produto (soft delete)

### Pedidos
- POST /orders — criar pedido
- GET /orders — listar pedidos

## Autor

Hugo Ferrari - [LinkedIn](https://www.linkedin.com/in/hugoferraripires/) - [GitHub](https://github.com/Hugo-Ferrari)
