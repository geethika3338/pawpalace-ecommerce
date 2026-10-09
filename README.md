# PawPalace — Pet E-commerce Application

PawPalace is a Java-based web application prototype for browsing pet products and practicing common e-commerce workflows. The Spring Boot application is located in the `pawpalace/` directory.

## Features

- User registration and login flows
- Browse and search products
- Product management for administrators
- Shopping cart and order workflows
- Product REST endpoints
- Server-rendered pages using Thymeleaf

## Tech Stack

- **Language:** Java 17
- **Backend:** Spring Boot 3, Spring Web MVC, Spring Data JPA, Spring JDBC
- **Frontend:** Thymeleaf, HTML, CSS, JavaScript, Bootstrap
- **Database:** MySQL
- **Build:** Maven

## Project Structure

```text
pawpalace-ecommerce/
├── pawpalace/
│   ├── pom.xml
│   ├── src/
│   └── README.md
└── .vscode/
```

## Prerequisites

- JDK 17
- MySQL Server
- Maven, or an IDE with Maven support

## Run Locally

1. Clone this repository.
2. Open a terminal in the application directory:

   ```bash
   cd pawpalace
   ```

3. Create the database configured by the application. The existing project documentation uses:

   ```sql
   CREATE DATABASE PawPalace;
   ```

4. Update `src/main/resources/application.properties` with your local database URL, username, and password. Do not commit real credentials.
5. Start the application:

   ```bash
   mvn spring-boot:run
   ```

6. Open the local URL and port configured by the application properties.

## API

The application documentation describes product endpoints under `/api/products`. Check the controller mappings in the source before relying on a specific request or payload.

## Notes

This is a learning project. Review the authentication, authorization, database configuration, and validation before deploying it publicly. Do not use default credentials in a production environment.

## Author

Geethika B. — [GitHub profile](https://github.com/geethika3338)
