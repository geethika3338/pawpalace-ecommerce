# PawPalace — Pet Products E-Commerce Application

PawPalace is a Java-based web application developed as a learning project to explore the development of an e-commerce platform for pet products. It uses Spring Boot for backend development, MySQL for data storage, and Thymeleaf with web technologies for rendering the user interface.

The project brings together common e-commerce workflows, including product browsing, shopping cart operations, order-related functionality, and product administration.

## Table of Contents

- [Project Overview](#project-overview)
- [Objectives](#objectives)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Application Architecture](#application-architecture)
- [Project Structure](#project-structure)
- [Application Workflow](#application-workflow)
- [API Overview](#api-overview)
- [Database Configuration](#database-configuration)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [Testing and Troubleshooting](#testing-and-troubleshooting)
- [Current Scope and Limitations](#current-scope-and-limitations)
- [Possible Future Improvements](#possible-future-improvements)
- [Learning Outcomes](#learning-outcomes)
- [Author](#author)

## Project Overview

PawPalace explores how a web-based pet products store can be developed using Java and the Spring Boot ecosystem. The application combines backend processing, database integration, REST-based product operations, and server-rendered web pages.

The project is intended to provide practical experience with the components commonly used in a Java backend application, including controllers, data persistence, application configuration, and web interfaces.

## Objectives

- Develop a web application using Java and Spring Boot.
- Connect an application to a MySQL relational database.
- Organize backend functionality using Spring web and data technologies.
- Build server-rendered pages with Thymeleaf.
- Explore common e-commerce workflows such as product browsing, cart operations, and order handling.
- Understand how REST endpoints support communication between application components.

## Features

### Product Browsing and Search

- Browse pet products through the application's web interface.
- Explore product information made available by the application.
- Use product search functionality where implemented.

### User Workflows

- User registration and login flows.
- Access the application through its available user-facing pages.
- Explore cart and order-related workflows supported by the current implementation.

### Product Administration

- Administrative product management functionality.
- Maintain product information through the available management workflows.

### Backend and Database Integration

- Spring Boot-based application structure.
- MySQL database integration.
- Spring Data JPA and Spring JDBC dependencies for data-related operations.
- REST endpoints for product operations.
- Thymeleaf templates for server-rendered pages.

> The exact behaviour of each feature depends on the current source code and configuration. This README describes the project's intended scope rather than claiming that every workflow is production-ready.

## Technology Stack

| Area | Technology |
|---|---|
| Programming language | Java 17 |
| Backend framework | Spring Boot 3.2.4 |
| Web layer | Spring Web MVC |
| Persistence | Spring Data JPA, Spring JDBC |
| Frontend rendering | Thymeleaf |
| Frontend technologies | HTML, CSS, JavaScript, Bootstrap |
| Database | MySQL |
| Build and dependency management | Maven |
| Testing framework | Spring Boot Starter Test |

## Application Architecture

PawPalace follows a typical Spring Boot web-application approach:

1. **Presentation layer:** Thymeleaf templates and frontend technologies provide the web interface.
2. **Web layer:** Spring MVC handles incoming web requests and routes them to the relevant application components.
3. **Application and data processing:** Backend code processes application operations and interacts with the database.
4. **Persistence layer:** MySQL stores application data, with Spring's database technologies supporting data access.

Conceptual request flow:

`Browser → Spring MVC → Backend Processing → Data Access → MySQL`

The response is then returned to the browser as a rendered page or an API response, depending on the request.

## Project Structure

The main Spring Boot application is located in the `pawpalace/` directory.

```text
pawpalace-ecommerce/
├── .vscode/
└── pawpalace/
    ├── pom.xml
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   └── resources/
    │   └── test/
    └── README.md
```

- `pom.xml` — Maven dependencies and build configuration.
- `src/main/java/` — Java application source code.
- `src/main/resources/` — application configuration and other resources, including templates and static assets where present.
- `src/test/` — test source directory.

The exact package and template organization can be explored directly in the source tree.

## Application Workflow

A typical user-facing workflow is:

1. Open the application in a browser.
2. Browse the pet products available in the application.
3. Use the available product search and detail views.
4. Access registration or login flows where configured.
5. Explore shopping cart and order-related functionality.
6. Administrators can use the available product management workflows.

The actual pages, validations, and permitted actions are determined by the current implementation.

## API Overview

The project includes product-related REST functionality.

| Endpoint | Purpose |
|---|---|
| `/api/products` | Product API entry point documented by the project |

The supported HTTP methods, request parameters, response formats, and additional endpoints should be confirmed from the controller mappings in the source code. The table intentionally does not assume that every CRUD operation is implemented.

For local testing, start the application and inspect the relevant controller classes to identify the exact supported requests.

## Database Configuration

PawPalace uses MySQL for relational data storage.

Before running the application:

1. Install and start MySQL Server.
2. Create the database configured for your local environment, or allow database creation only if the configured MySQL user has the necessary permissions.
3. Set the database URL, username, and password in your local application configuration.
4. Keep real credentials out of source control.

For safer configuration, use environment variables for sensitive values:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Configure `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` in your local environment before starting the application. Keep database settings consistent with your actual MySQL installation.

## Getting Started

### Prerequisites

- JDK 17
- MySQL Server
- Maven
- Git
- An IDE such as Eclipse or IntelliJ IDEA, or a terminal

### 1. Clone the repository

```bash
git clone https://github.com/geethika3338/pawpalace-ecommerce.git
```

### 2. Navigate to the application directory

```bash
cd pawpalace-ecommerce/pawpalace
```

### 3. Configure the database

Create the database configured for the application in MySQL, then configure the database URL and credentials in your local environment.

Do not copy personal database passwords into the README or commit them to GitHub.

### 4. Build the application

```bash
mvn clean install
```

### 5. Run the application

```bash
mvn spring-boot:run
```

Wait for the Spring Boot startup logs to indicate that the application has started successfully.

## Running the Application

Open the local address using the port configured in your application settings. If you have retained the repository's current local port configuration, the application is configured for port `8084`.

```text
http://localhost:8084
```

If the port has been changed, use the port shown in your local configuration and startup logs.

## Testing and Troubleshooting

### Database connection errors

- Confirm that MySQL Server is running.
- Check the database name, username, password, and JDBC URL.
- Verify that the database user has the required permissions.
- Check the application logs for the underlying connection error.

### Maven or Java version errors

- Confirm that JDK 17 is installed and selected.
- Check the output of `java -version` and `mvn -version`.
- Run Maven commands from the directory containing `pom.xml`.

### Port already in use

If the configured port is occupied, stop the process using it or select another available port in the local application configuration.

### API response issues

Review the controller mappings, request methods, expected request data, and application logs to determine the cause.

## Current Scope and Limitations

PawPalace is a learning project and should not be considered production-ready without further verification and testing.

Before deployment, review:

- Authentication and authorization behaviour.
- Input validation and error handling.
- Database credentials and secret management.
- Transaction handling and order consistency.
- Product and order data integrity.
- Automated test coverage.
- Production database settings and deployment configuration.

## Possible Future Improvements

- Strengthen authentication and role-based access control.
- Add consistent validation and user-friendly error messages.
- Expand automated unit and integration tests.
- Improve product filtering, categories, and search.
- Refine cart and order lifecycle handling.
- Add structured logging and API documentation.
- Introduce deployment configuration suitable for a production environment.

These are potential improvements, not claims that they have already been implemented.

## Learning Outcomes

This project provides practical exposure to:

- Java backend development with Spring Boot.
- Spring MVC request handling.
- Database connectivity using MySQL.
- Spring Data JPA and Spring JDBC.
- Thymeleaf-based server-rendered interfaces.
- REST API concepts.
- Maven dependency management and application execution.
- Configuring and troubleshooting a full-stack web application.

## Author

**Geethika B.**

- GitHub: https://github.com/geethika3338
