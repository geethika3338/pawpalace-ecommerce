# PawPalace - Simple E-Commerce Website

PawPalace is a beginner-friendly E-Commerce Web Application built using Java Spring Boot, Spring MVC, Spring REST, MySQL, HTML, CSS, JavaScript, and Bootstrap.

## Features

*   **User Module**: Registration, Login, Logout.
*   **Product Module**: View all products, search products. Admin can Add, Update, and Delete products.
*   **Cart Module**: Add items to cart, remove items, view total amount. (Uses Spring JDBC for database connectivity demonstration).
*   **Order Module**: Place orders, view order history.
*   **REST APIs**: Exposes basic REST APIs for the Product module.

## Technologies Used

*   **Frontend**: HTML5, CSS3, JavaScript, Bootstrap 5, Thymeleaf.
*   **Backend**: Java 17, Spring Boot 3, Spring Web MVC, Spring REST, Spring Data JPA, Spring JDBC.
*   **Database**: MySQL.
*   **Build Tool**: Maven.

## Setup Instructions

### Prerequisites

1.  **Java Development Kit (JDK) 17** installed.
2.  **Maven** installed.
3.  **MySQL Server** installed and running.

### Database Setup

1.  Open your MySQL client or command line.
2.  Create a new database named `PawPalace`:
    ```sql
    CREATE DATABASE PawPalace;
    ```
3.  Ensure your MySQL username is `root` with no password (or an empty string). If you have a different username or password, update the `src/main/resources/application.properties` file:
    ```properties
    spring.datasource.username=YOUR_USERNAME
    spring.datasource.password=YOUR_PASSWORD
    ```
    *(Note: Tables and dummy data will be automatically created upon the first application startup via `schema.sql`).*

### Running the Application

1.  Open a terminal and navigate to the project root directory (`PawPalace`).
2.  Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```
3.  The application will start on port `8080`.
4.  Open your web browser and navigate to:
    ```
    http://localhost:8080/
    ```

### Default Credentials

*   **Admin User**:
    *   Username: `admin`
    *   Password: `admin`

## REST API Endpoints

*   `GET /api/products` - Get all products
*   `GET /api/products/{id}` - Get product by ID
*   `POST /api/products` - Create a new product
*   `PUT /api/products/{id}` - Update a product
*   `DELETE /api/products/{id}` - Delete a product
