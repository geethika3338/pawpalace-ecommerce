# PawPalace — Pet E-commerce Application

PawPalace is a learning project that explores the development of a pet products e-commerce web application using Java and Spring Boot.

## Features

- Browse and search pet products
- User registration and login flows
- Product management for administrators
- Shopping cart and order workflows
- REST endpoints for product operations
- Server-rendered pages using Thymeleaf

## Tech Stack

| Area | Technologies |
|---|---|
| Language | Java 17 |
| Backend | Spring Boot 3, Spring Web MVC, Spring Data JPA, Spring JDBC |
| Frontend | Thymeleaf, HTML, CSS, JavaScript, Bootstrap |
| Database | MySQL |
| Build tool | Maven |

## Project Structure

The Spring Boot application is located in the `pawpalace/` directory.

```text
pawpalace-ecommerce/
├── pawpalace/
│   ├── pom.xml
│   ├── src/
│   └── README.md
└── .vscode/
```

## Run Locally

### Prerequisites

- JDK 17
- MySQL Server
- Maven

### Setup

1. Clone the repository.
2. Open a terminal in the application directory:

   ```bash
   cd pawpalace
   ```

3. Create the database expected by the application:

   ```sql
   CREATE DATABASE PawPalace;
   ```

4. Update `src/main/resources/application.properties` with your local database URL, username, and password. Never commit real credentials.
5. Start the application:

   ```bash
   mvn spring-boot:run
   ```

6. Open the local address and port configured by the application.

## API

The project documentation describes product endpoints under `/api/products`. Check the controller mappings for the supported operations and request formats.

## Notes

This is a learning project, not a claim of production readiness. Authentication, authorization, validation, database configuration, and default credentials should be reviewed before deployment.

## Author

Geethika B. — [GitHub Profile](https://github.com/geethika3338)
