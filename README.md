#  Pedidos API

API REST para gerenciamento de pedidos — usuários, produtos e pedidos com múltiplos itens.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-green)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-green)
![Docker](https://img.shields.io/badge/Docker-blue)

---

##  Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias](#tecnologias)
- [Como Rodar](#como-rodar)
- [Endpoints](#endpoints)

---

## Sobre o Projeto

API desenvolvida para gerenciar um sistema de pedidos, permitindo o cadastro de usuários,
produtos e pedidos com múltiplos itens. O sistema conta com autenticação JWT,
soft delete de produtos e usuários, cálculo automático do total do pedido,
preço capturado no momento da compra e documentação automática via Swagger.

---

##  Tecnologias

- **Java 21** — versão LTS da linguagem
- **Spring Boot 4** — framework principal para criação da API
- **Spring Security + JWT** — autenticação e autorização com token
- **Spring Data JPA + Hibernate** — mapeamento objeto-relacional
- **PostgreSQL** — banco de dados relacional em produção
- **Docker + Docker Compose** — containerização da aplicação e do banco
- **Swagger / OpenAPI 3** — documentação interativa da API
- **Maven** — gerenciador de dependências
- **Lombok** — redução de boilerplate

---

##  Como Rodar

### Com Docker (recomendado)

Pré-requisitos:
- Docker instalado

```bash
# Clone o repositório
git clone https://github.com/Hugo-Ferrari/pedidos-api.git

# Entre na pasta
cd pedidos-api

# Suba a aplicação e o banco juntos
docker-compose up
```

Acesse a documentação em: http://localhost:8080/swagger-ui/index.html

### Sem Docker

Pré-requisitos:
- Java 21+
- Maven
- PostgreSQL instalado e rodando

```bash
# Clone o repositório
git clone https://github.com/Hugo-Ferrari/pedidos-api.git

# Entre na pasta
cd pedidos-api

# Configure as credenciais em src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/pedidos_api
    username: postgres
    password: sua_senha

# Rode o projeto
./mvnw spring-boot:run
```

---

##  Endpoints

###  Autenticação

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| POST | /users/auth/register | Cadastrar usuário | ❌ |
| POST | /users/auth/login | Login e obter token JWT | ❌ |

###  Usuários

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| GET | /users | Listar usuários | ✅ |
| DELETE | /users/{id} | Soft delete | ✅ |

###  Produtos

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| POST | /products | Criar produto | ✅ |
| GET | /products | Listar produtos ativos | ✅ |
| GET | /products/categoria/{categoria} | Listar por categoria | ❌ |
| PUT | /products/{id} | Atualizar completo | ✅ |
| PATCH | /products/{id} | Atualizar parcial | ✅ |
| DELETE | /products/{id} | Soft delete | ✅ |

### 🛒 Pedidos

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| POST | /orders | Criar pedido | ✅ |
| GET | /orders | Listar pedidos | ✅ |
| GET | /orders/meus-pedidos/{usuarioId} | Pedidos do usuário | ✅ |

---

## 👤 Autor

Hugo Ferrari — [LinkedIn](https://www.linkedin.com/in/hugoferraripires/) — [GitHub](https://github.com/Hugo-Ferrari)
