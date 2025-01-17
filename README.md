Pode tambem ser consultado no Notion: https://married-chinchilla-de0.notion.site/API-RESTful-para-Gerenciamento-de-Livros-17e1c5c0bcca804e83a5ee1e93de5783?pvs=4

API RESTful para Gerenciamento de Livros

Este projeto é uma API RESTful desenvolvida em Spring Boot para o gerenciamento de livros em uma livraria fictícia. Ele oferece funcionalidades básicas de CRUD (Create, Read, Update, Delete) e permite a busca de livros por gênero e autor. A solução foi implementada com foco em boas práticas de arquitetura e reprodutibilidade.

## Arquitetura de Solução e Técnica

A solução foi implementada utilizando as seguintes tecnologias e ferramentas:

- **Spring Boot**: Framework utilizado para construção da API.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar as informações dos livros.
- **Docker**: Ferramenta para containerização, permitindo a execução reprodutível do projeto.
- **Lombok**: Reduziu o boilerplate no código, especialmente em classes de modelo.
- **Maven**: Gerenciador de dependências e build do projeto.

### Estrutura do Projeto

A aplicação segue uma arquitetura baseada em camadas:

1. **Controller**: Camada de entrada que expõe os endpoints REST.
2. **Service**: Contém a lógica de negócios da aplicação.
3. **Repository**: Responsável pela interação com o banco de dados usando Spring Data JPA.
4. **Entity**: Representa as entidades do banco de dados, incluindo o mapeamento.

### Diagrama da Arquitetura

```
[Controller] <--> [Service] <--> [Repository] <--> [Banco de Dados]

```

### Decisões de Design

- **Reutilização de Código**: Consultas reutilizáveis na camada Repository.
- **Validação e Tratamento de Erros**: Tratamento de exceções e respostas HTTP padronizadas.
- **Facilidade de Extensão**: A estrutura modular permite a adição de novas funcionalidades.

---

## Plano de Implementação

### Entidade `Books`

A entidade `Books` representa os livros armazenados no banco de dados. Ela possui os seguintes atributos:

- `id` (Long): Identificador único.
- `title` (String): Título do livro.
- `author` (String): Autor do livro.
- `mainGenre` (String): Gênero principal do livro.
- `subGenre` (String): Subgênero do livro.
- `type` (String): Tipo do livro (e.g., eBook, físico).
- `price` (BigDecimal): Preço do livro.
- `rating` (BigDecimal): Classificação do livro (de 0.0 a 10.0).
- `no_of_people_rated` (Integer): Número de pessoas que avaliaram o livro.
- `url` (String): Link relacionado ao livro.

### Endpoints Implementados

A API fornece os seguintes endpoints REST:

1. **`GET /books`**
    - Retorna a lista completa de livros.
    - **Exemplo de resposta**:
        
        ```json
        [
          {
            "id": 1,
            "title": "Spring Boot in Action",
            "author": "Craig Walls",
            "mainGenre": "Programming",
            "subGenre": "Java",
            "type": "Physical",
            "price": 49.99,
            "rating": 9.5,
            "no_of_people_rated": 120,
            "url": "http://example.com/spring-boot"
          }
        ]
        
        ```
        
2. **`GET /books/{id}`**
    - Busca um livro pelo seu ID.
    - **Exemplo de resposta**:
        
        ```json
        {
          "id": 1,
          "title": "Spring Boot in Action",
          "author": "Craig Walls",
          "mainGenre": "Programming",
          "subGenre": "Java",
          "type": "Physical",
          "price": 49.99,
          "rating": 9.5,
          "no_of_people_rated": 120,
          "url": "http://example.com/spring-boot"
        }
        
        ```
        
3. **`GET /books/genre/{genre}`**
    - Busca livros pelo gênero principal ou secundário.
4. **`GET /books/author/{author}`**
    - Busca livros de um autor específico.

---

## Configuração e Execução do Projeto

### Requisitos

- Docker e Docker Compose instalados.
- Java 17+.
- Maven instalado.

### Passos para Configuração

1. Clone o repositório:
    
    ```bash
    git clone https://github.com/<usuario>/<repositorio>.git
    cd <repositorio>
    
    ```
    
2. Execute o projeto com Docker Compose:
    
    ```bash
    docker-compose up --build
    
    ```
    
3. Acesse a aplicação em [http://localhost:8080](http://localhost:8080/).

### Configuração do Banco de Dados

Um script SQL será executado automaticamente para criar a tabela `books` e inserir dados iniciais. Exemplo:

```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    main_genre VARCHAR(255),
    sub_genre VARCHAR(255),
    type VARCHAR(255),
    price NUMERIC(10,2),
    rating NUMERIC(2,1),
    no_of_people_rated INTEGER,
    url VARCHAR(500)
);

INSERT INTO books (title, author, main_genre, sub_genre, type, price, rating, no_of_people_rated, url)
VALUES
('Spring Boot in Action', 'Craig Walls', 'Programming', 'Java', 'Physical', 49.99, 9.5, 120, 'http://example.com/spring-boot');

```

---

## Melhorias e Considerações Finais

### Possíveis Melhorias

1. **Autenticação e Autorização**
    - Implementar Spring Security para proteger os endpoints.
2. **Paginas de Resultados**
    - Adicionar paginação aos endpoints que retornam listas.
3. **Testes Automatizados**
    - Criar testes unitários e de integração usando JUnit.

### Desafios Encontrados

- Integração inicial entre Spring Boot e Docker.
- Ajustes na serialização de dados complexos, como `BigDecimal`.

---

Com este projeto, buscamos oferecer uma solução simples e reprodutível, utilizando ferramentas modernas e boas práticas de desenvolvimento. Para mais detalhes, consulte a documentação no repositório.