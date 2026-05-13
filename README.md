# Pedidos API

API REST para gerenciamento de pedidos desenvolvida com Java e Spring Boot.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT
- Swagger (OpenAPI 3)
- Maven
- Lombok

## Funcionalidades

- Cadastro e login de usuários com autenticação JWT
- CRUD completo de produtos com soft delete
- Sistema de pedidos com múltiplos itens
- Cálculo automático do total do pedido
- Preço capturado no momento da compra
- Rotas protegidas por token JWT
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
- POST /users/auth/login — retorna token JWT
- GET /users — listar usuários (autenticado)
- DELETE /users/{id} — soft delete (autenticado)

### Produtos
- POST /products — criar produto (autenticado)
- GET /products — listar produtos ativos (autenticado)
- PUT /products/{id} — atualizar completo (autenticado)
- PATCH /products/{id} — atualizar parcial (autenticado)
- DELETE /products/{id} — soft delete (autenticado)

### Pedidos
- POST /orders — criar pedido (autenticado)
- GET /orders — listar pedidos (autenticado)

## Autor

Hugo Ferrari - [LinkedIn](https://www.linkedin.com/in/hugoferraripires/) - [GitHub](https://github.com/Hugo-Ferrari)
