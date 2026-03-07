 System Gym API

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de usuários e agendamentos de academia.

O sistema permite cadastro de usuários, autenticação com **JWT** e criação de agendamentos vinculados aos usuários.

##  Tecnologias utilizadas

- Java 25
- Spring Boot
- Spring Security
- JWT Authentication
- JPA / Hibernate
- Maven
- MySQL / H2
- REST API

##  Funcionalidades

- Cadastro de usuários
- Login com autenticação JWT
- Criação de agendamentos
- Atualização de agendamentos
- Busca de agendamentos por ID
- Exclusão de agendamentos
- Relacionamento entre usuário e agendamento

##  Segurança

O sistema utiliza:

- **Spring Security**
- **Autenticação JWT**
- Criptografia de senha com **BCrypt**

##  Endpoints principais

### Autenticação

POST /auth/register  
POST /auth/login

### Usuários

GET /users  
GET /users/{id}

### Agendamentos

POST /users/{id}/agendamentos  
GET /agendamentos/{id}  
PUT /agendamentos/{id}  
DELETE /agendamentos/{id}

## 🛠️ Como rodar o projeto

1. Clone o repositório
