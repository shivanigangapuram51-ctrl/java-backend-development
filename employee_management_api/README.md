# Employee Management API – Architecture Notes

## 1. Architecture Overview

The application follows a layered architecture using Spring Boot, Spring Web, Spring Data JPA and an H2 database.

The request flow is:

Controller → Service → Repository → Database

## 2. Layer Responsibilities

### Controller
Receives HTTP requests, validates request DTOs and returns HTTP responses.

### Service
Contains business rules, processes employee requests and coordinates repository operations.

### Repository
Uses Spring Data JPA to save, retrieve, update and delete employee records.

### Entity
Represents the employee database table and its persistent fields.

### DTO
Transfers request data between the client and the application. Validation annotations define the required input constraints.

### Exception
Handles application errors and returns consistent error responses.

## 3. Dependency Injection

The application uses constructor injection to provide dependencies to the controller and service layers. This reduces tight coupling and improves testability.

## 4. Entity Ownership

The Employee entity represents persistent employee data. The repository manages database access, while the service controls business operations involving employee records. The controller works with incoming requests and outgoing responses.

## 5. Execution Steps

1. Open the project in IntelliJ IDEA.
2. Load Maven dependencies.
3. Run EmployeeManagementApiApplication.
4. Test the health endpoint.
5. Test employee API endpoints using Postman.

## 6. Known Limitations

The development profile uses an in-memory H2 database. Data may be lost when the application restarts. Production database configuration and security settings require separate consideration.