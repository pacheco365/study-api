# Study API

Este repositório contém um projeto desenvolvido como parte dos estudos da disciplina de desenvolvimento de APIs RESTful. O objetivo é praticar a construção de uma API estruturada com boas práticas de arquitetura, seguindo os conceitos de **MVC**, **camadas de serviço**, **DTOs**, e **integração com banco de dados** utilizando o ecossistema **Spring Boot**.

---

## 📚 Objetivos do Projeto

- Criar e expor endpoints de uma API REST utilizando o Spring Boot.
- Praticar o uso de DTOs para transferência de dados.
- Implementar operações CRUD com persistência em banco de dados relacional.
- Aplicar organização de código por camadas (Controller, Service, Repository).
- Configurar e utilizar `application.properties` para conexão com banco de dados.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- Banco de Dados (MySQL / PostgreSQL / H2)
- Postman (testes manuais de endpoints)

---

## 📁 Estrutura do Projeto

```bash
src/
└── main/
    └── java/
        └── com/github/acnaweb/study_apix/
            ├── controller/           # Camada responsável pelos endpoints da API
            ├── dto/                  # Objetos de transferência de dados
            ├── model/                # Entidades que representam as tabelas
            ├── repository/           # Interface com o banco de dados
            └── service/              # Lógica de negócio
    └── resources/
        └── application.properties    # Configurações do projeto
```

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/pacheco365/study-api.git
```

2. Acesse o projeto:
```bash
cd study-api
```

3. Configure o arquivo `application.properties` com os dados do seu banco.

4. Execute com Maven:
```bash
./mvnw spring-boot:run
```

---
