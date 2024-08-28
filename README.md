# Race Driver Life

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/EltonC06/RaceDriverLife/blob/main/LICENSE)

## About the Project

Race Driver Life is a Java Spring Boot web back-end application created for educational purposes.

The application's objective is to motivate the users to be more productive by simulating daily tasks as if they were part of a car race. Users create and manage their tasks with the goal of completing them to win the race of the day.

## Technologies Used

### Back-End
- Java (Spring Boot)
- MySQL

## How to Run the Project

### Prerequisites
- Java IDE (Spring Tool Suite recomended)
- Java 17
- MySQL

### Step-by-Step Guide

1. **Clone the Repository**
   ```bash
   git clone git@github.com:EltonC06/RaceDriverLife.git
   ```

2. **Configure the Database**
   - Create a MySQL database and configure its credentials (database URL, user, password) in the project configuration file located at: `src/main/resources/application.properties`.

3. **Open the Project**
   - Open the project in a Java IDE with Spring Boot support (Spring Tool Suite is recomemended).

4. **Run the Application**
   - In your IDE, click to run the application.

5. **Testing the Application**
   - Since the application does not have a front-end interface, use a HTTP client like Postman to interact with the API endpoints.

## API Endpoints

Here are the main endpoints available for interacting with the application:

### User

- **Create User**
  - **Method:** `POST`
  - **URL:** `localhost:8080/users`
  - **Description:** Create a new user.
  - **Body:** `{ "userName": "Guilherme", "password": "4321" }`

- **Get user by id**
  - **Method:** `GET`
  - **URL:** `localhost:8080/users/{id}`
  - **Description:** Get an user by id and its data.

- **Get Users**
  - **Method:** `GET`
  - **URL:** `localhost:8080/users`
  - **Description:** Get all users created.

- **Update User**
  - **Method:** `PUT`
  - **URL:** `localhost:8080/users/{id}`
  - **Description:** Update the information about the user selected.
  - **Body:** `{ "userName": "Guilherme", "password": "novaSenha1" }`

- **Delete User**
  - **Method:** `DELETE`
  - **URL:** `localhost:8080/users/{id}`
  - **Description:** Delete an user.

### RaceCentral

- **Get RaceCentral by Id**
  - **Method:** `GET`
  - **URL:** `localhost:8080/racecentrals/{id}`
  - **Description:** Get the data of a specific RaceCentral.

- **Get RaceCentrals**
  - **Method:** `GET`
  - **URL:** `localhost:8080/racecentrals`
  - **Description:** Get all RaceCentrals created.

- **Update RaceCentral automatically**
  - **Method:** `PUT`
  - **URL:** `localhost:8080/racecentrals/{id}`
  - **Description:** If an user finishes a race, this request update automatically the RaceCentral data of the specific user.

- **Update RaceCentral manually**
  - **Method:** `PUT`
  - **URL:** `localhost:8080/racecentrals/manual/{id}`
  - **Description:** Update manually the information of a specific RaceCentral.
  - **Body:** `{ "racesWon": 1, "racesDisputed": 1 }`

### Race

- **Get Race by Id**
  - **Method:** `GET`
  - **URL:** `localhost:8080/races/{id}`
  - **Description:** Get a specific Race.

- **Get Races**
  - **Method:** `GET`
  - **URL:** `localhost:8080/races`
  - **Description:** Get all Races created.

- **Update Race** (Not recommended to use)
  - **Method:** `PUT` 
  - **URL:** `localhost:8080/races/{id}`
  - **Description:** Update the information of the Race selected. 
  - **Body:** `{ "doneTasks": 5, "taskQuantity": 10, "isActive": true }`

### Task

- **Create Task**
  - **Method:** `POST`
  - **URL:** `localhost:8080/tasks`
  - **Description:** Create a new task.
  - **Body:** `{ "raceId": 1, "taskName": "Go for a walk", "taskStatus": "PENDING" }` (RaceId is the same id of its user)

- **Get Task by Id**
  - **Method:** `GET`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Description:** Get a specific Task.

- **Get Tasks**
  - **Method:** `GET`
  - **URL:** `localhost:8080/tasks`
  - **Description:** Get all Tasks created.

- **Get Race Based Tasks**
  - **Method:** `GET`
  - **URL:** `localhost:8080/tasks/racebased/{id}`
  - **Description:** Get all Tasks created of a specific user.

- **Update Tasks**
  - **Method:** `PUT`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Description:** Update the information of a specific Task.
  - **Body:** `{ "raceId": "1", "taskName": "Go shopping", "taskStatus": "DONE" }`

- **Delete Task**
  - **Method:** `DELETE`
  - **URL:** `localhost:8080/tasks/{id}`
  - **Description:** Delete a specific Task.

- **Delete Race Based Tasks**
  - **Method:** `DELETE`
  - **URL:** `localhost:8080/tasks/racebased/{id}`
  - **Description:** Delete all tasks from a specif RaceId.


### Observations

- When a new user is created (by POST method), the entity RaceCentral and Race will be created and associated automatically to the user.
- The program was tested using only Spring Tool Suite.
- Ensure that MySQL is running locally.

## How You Can Contribute

- Spring Security implementation for user passwords.
- Improve the task management and validation.
- Develop a front-end interface for data visualization.

## Author

Elton da Costa Oliveira

[LinkedIn](https://www.linkedin.com/in/elton-da-costa/)
