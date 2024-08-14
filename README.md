# Race Driver Life

(https://github.com/EltonC06/RaceDriverLife/blob/main/LICENSE)

## Sobre o Projeto

Race Driver Life é uma aplicação Java Spring Boot web back-end criada para fins educacionais.

A aplicação tem como objetivo motivar os usuários a serem mais produtivos, simulando tarefas do cotidiano como se fosse uma corrida automobilística. Os usuários implementam e gerenciam suas tarefas com o objetivo de completá-las para vencer a corrida do dia.

## Tecnologias Utilizadas

### Back End
- Java (Spring Boot)
- MySQL

## Como Executar o Projeto

### Pré-requisitos
- IDE para Java (Spring Tool Suite recomendado)
- Java 17
- MySQL

### Passo a Passo

1. **Clonar o Repositório**
   ```bash
   git clone git@github.com:EltonC06/RaceDriverLife.git
   ```

2. **Configurar o Banco de Dados**
   - Crie um banco de dados MySQL e configure as credenciais (URL do banco, usuário, senha) no arquivo de configuração do projeto: `src/main/resources/application.properties`.

3. **Entrar na Pasta do Projeto**
   - Abra o projeto em uma IDE Java com suporte ao Spring Boot.

4. **Executar o Programa**
   - Na aba superior da tela clique em `run` racedriverlife-app.

5. **Testando a Aplicação**
   - Use um cliente HTTP, como o **Postman**, para testar as requisições **GET**, **PUT**, **POST** e **DELETE** para as entidades **Usuário**, **RaceCentral**, **Race** e **Tasks**.

## Endpoints da API

Aqui estão os principais endpoints disponíveis para interação com a API:

### Usuário

- **Criar Usuário**
  - **Método:** `POST`
  - **URL:** `localhost:8080/users`
  - **Descrição:** Cria um novo usuário.
  - **Body:** `{ "userName": "Guilherme", "password": "4321" }`

- **Obter Usuário por ID**
  - **Método:** `GET`
  - **URL:** `localhost:8080/users/{id}`
  - **Descrição:** Obtém os detalhes de um usuário específico.

- **Obter Usuários**
  - **Método:** `GET`
  - **URL:** `localhost:8080/users`
  - **Descrição:** Obtém todos os usuários registrados até o momento.

- **Atualizar Usuário**
  - **Método:** `PUT`
  - **URL:** `localhost:8080/users/{id}`
  - **Descrição:** Atualiza as informações de um usuário existente.
  - **Body:** `{ "userName": "Guilherme", "password": "novaSenha1" }`

- **Deletar Usuário**
  - **Método:** `DELETE`
  - **URL:** `localhost:8080/users/{id}`
  - **Descrição:** Deleta um usuário específico.

### RaceCentral

- **Obter RaceCentral por ID**
  - **Método:** `GET`
  - **URL:** `localhost:8080/racecentrals/{id}`
  - **Descrição:** Obtém os detalhes de um RaceCentral específico.

- **Obter RaceCentrals**
  - **Método:** `GET`
  - **URL:** `localhost:8080/racecentrals`
  - **Descrição:** Obtém todos os RaceCentrals registrados até o momento.

- **Atualizar automaticamente o RaceCentral**
  - **Método:** `PUT`
  - **URL:** `localhost:8080/racecentrals/manual/{id}`
  - **Descrição:** Caso o usuário tenha concluído uma corrida, atualiza automaticamente os dados do seu RaceCentral.

- **Atualizar manualmente o RaceCentral**
  - **Método:** `PUT`
  - **URL:** `localhost:8080/racecentrals/manual/{id}`
  - **Descrição:** Atualiza manualmente as informações de um RaceCentral existente.
  - **Body:** `{ "racesWon": 1, "racesDisputed": 1 }`

### Race

- **Obter Race por ID**
  - **Método:** `GET`
  - **URL:** `localhost:8080/races/{id}`
  - **Descrição:** Obtém os detalhes de uma Race específica.

- **Obter Races**
  - **Método:** `GET`
  - **URL:** `localhost:8080/races`
  - **Descrição:** Obtém todas as Races registradas até o momento.

- **Atualizar Race** (Não é recomendado o uso deste método)
  - **Método:** `PUT` 
  - **URL:** `localhost:8080/races/{id}`
  - **Descrição:** Atualiza as informações de uma Race existente. 
  - **Body:** `{ "doneTasks": 5, "taskQuantity": 10, "isActive": true }`

### Tarefa (Task)

- **Criar Tarefa**
  - **Método:** `POST`
  - **URL:** `localhost:8080/tasks`
  - **Descrição:** Cria uma nova tarefa.
  - **Body:** `{ "raceId": 1, "taskName": "Passear", "taskStatus": "PENDING" }`  (RaceId é o mesmo Id do usuário)

- **Obter Tarefa por ID**
  - **Método:** `GET`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Descrição:** Obtém os detalhes de uma tarefa específica.

- **Obter Tarefas**
  - **Método:** `GET`
  - **URL:** `localhost:8080/tasks}`
  - **Descrição:** Obtém todas as tarefas registradas até o momento.

- **Obter Todas as Tarefas Baseadas na Corrida**
  - **Método:** `GET`
  - **URL:** `localhost:8080/tasks/racebased/{id}`
  - **Descrição:** Obtém todas as tarefas de um usuário específico.

- **Atualizar Tarefa**
  - **Método:** `PUT`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Descrição:** Atualiza as informações de uma tarefa existente.
  - **Body:** `{ "raceId": "1", "taskName": "Fazer compras", "taskStatus": "DONE" }` (RaceId é o mesmo Id do usuário)

- **Deletar Tarefa**
  - **Método:** `DELETE`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Descrição:** Deleta uma tarefa específica.

- **Deletar Todas Tarefas Baseada na Corrida**
  - **Método:** `DELETE`
  - **URL:** `localhost:8080/tasks/racebased/{id}`
  - **Descrição:** Deleta todas as tarefas de um usuário específico.


### Observações

- Quando um novo usuário é criado (Através do método Post), as entidades RaceCentral e Race são geradas e associadas automaticamente ao usuário.
- O programa foi testado utilizando apenas Spring Tool Suite.
- Certifique-se de que o MySQL esteja em execução localmente.

## Como Você Pode Contribuir

- Implementação do Spring Security para as senhas dos usuários.
- Melhorar o gerenciamento e validação das tarefas.
- Desenvolver uma interface front-end para visualização dos dados e resultados das corridas.

## Autor

Elton da Costa Oliveira

[LinkedIn](https://www.linkedin.com/in/elton-da-costa/)
