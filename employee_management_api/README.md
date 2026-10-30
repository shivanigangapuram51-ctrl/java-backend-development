# Employee Management API & SaaS Backend

## 1. Project Overview

The Employee Management API and SaaS Backend is a Java Spring Boot application developed to demonstrate REST API development, layered architecture, dependency injection, database persistence, request validation, exception handling, security, and automated testing.

The project was developed in two stages. The first stage focuses on employee CRUD operations. The second stage extends the backend with customer and subscription management for a SaaS application.

The application uses a layered architecture to separate API handling, business logic, data access, and database operations.

## 2. Project Objectives

- Build RESTful APIs using Spring Boot.
- Implement controller, service, repository, entity, DTO, and exception layers.
- Apply constructor-based dependency injection.
- Validate incoming requests using Jakarta Validation.
- Persist data using Spring Data JPA.
- Implement employee CRUD operations.
- Manage customers and their subscriptions.
- Handle exceptions through centralized error handling.
- Apply transaction management and database constraints.
- Implement authentication and authorization.
- Test successful requests, invalid inputs, and failure scenarios.
- Document API endpoints, configuration, and execution steps.

## 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database access and ORM |
| Jakarta Validation | Request validation |
| Spring Security | Authentication and authorization |
| Maven | Dependency management and build automation |
| H2 / PostgreSQL | Relational database, depending on configuration |
| JUnit | Unit testing |
| MockMvc | Testing HTTP endpoints |
| Testcontainers | Database integration testing, if configured |
| Flyway | Database versioning and migrations, if configured |
| Postman | API testing |
| IntelliJ IDEA | Development environment |
| Git and GitHub | Version control |

## 4. Architecture

The application follows a layered architecture.

```text
Client / Postman
       |
       v
REST Controller
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
Relational Database
```

### Layer Responsibilities

**Controller Layer**
- Defines REST endpoints.
- Accepts HTTP requests.
- Receives and validates request DTOs.
- Returns appropriate HTTP responses.

**Service Layer**
- Contains business logic.
- Validates business rules.
- Coordinates repository operations.
- Uses transactions where required.

**Repository Layer**
- Provides database access through Spring Data JPA.
- Supports CRUD operations and custom queries.

**Entity Layer**
- Represents database entities and relationships.
- Defines persistence mappings.

**DTO Layer**
- Transfers request data between clients and the application.
- Separates API request structures from persistence entities.

**Exception Layer**
- Contains custom exceptions and centralized exception handling.
- Returns structured error responses.

## 5. Employee Management API

The Employee Management API provides endpoints for managing employee records.

### Supported Operations

- Create an employee.
- Retrieve all employees.
- Retrieve an employee by ID.
- Update an employee.
- Delete an employee.
- Validate incoming employee data.
- Return structured errors for invalid requests and missing employees.

### Employee Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/v1/employees` | Create an employee |
| GET | `/api/v1/employees` | Retrieve all employees |
| GET | `/api/v1/employees/{id}` | Retrieve an employee by ID |
| PUT | `/api/v1/employees/{id}` | Update an employee |
| DELETE | `/api/v1/employees/{id}` | Delete an employee |

The endpoints assume these mappings are implemented in `EmployeeController`.

### Example: Create an Employee

**Request**

```http
POST /api/v1/employees
Content-Type: application/json
```

```json
{
  "name": "Shivani",
  "email": "shivani@example.com",
  "salary": 30000
}
```

The actual request fields must match the implementation of `EmployeeRequest`.

### Validation

Employee request validation may include:

- Required employee name.
- Valid email format.
- Positive salary.
- Appropriate handling of missing or invalid fields.

## 6. Customer Management API

The customer module supports customer registration and retrieval.

### Customer Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/v1/customers` | Create a customer |
| GET | `/api/v1/customers` | Retrieve all customers |
| GET | `/api/v1/customers/{id}` | Retrieve a customer by ID |

### Example: Create a Customer

**Request**

```http
POST /api/v1/customers
Content-Type: application/json
```

```json
{
  "name": "Shivani",
  "email": "shivani@example.com"
}
```

A successful creation request should return HTTP `201 Created`, provided the request is valid and the database operation succeeds.

The customer module also checks for duplicate email addresses when that validation is enabled.

## 7. Subscription Management API

The subscription module manages subscriptions associated with customers.

### Subscription Features

- Create a subscription for an existing customer.
- Retrieve a subscription by ID.
- Retrieve subscriptions belonging to a customer.
- Update a subscription's status.
- Validate subscription request data.
- Handle requests referencing customers or subscriptions that do not exist.

### Subscription Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/v1/subscriptions` | Create a subscription |
| GET | `/api/v1/subscriptions/{id}` | Retrieve a subscription |
| GET | `/api/v1/subscriptions/customer/{customerId}` | Retrieve subscriptions for a customer |
| PATCH | `/api/v1/subscriptions/{id}/status?status=CANCELLED` | Update subscription status |

These endpoints assume the corresponding controller mappings have been implemented.

### Subscription Plans

The subscription plan may use the following values:

- `FREE`
- `BASIC`
- `PRO`
- `ENTERPRISE`

The subscription status may use:

- `ACTIVE`
- `CANCELLED`
- `EXPIRED`

The accepted values must match the enums in the project.

### Example: Create a Subscription

**Request**

```http
POST /api/v1/subscriptions
Content-Type: application/json
```

```json
{
  "customerId": 1,
  "plan": "BASIC",
  "startDate": "2026-10-30",
  "endDate": "2027-10-30"
}
```

The referenced customer must already exist in the database.

The dates are examples. Use dates appropriate to your application's validation rules.

## 8. Database Design

The application uses relational database persistence through Spring Data JPA.

### Main Entities

**Employee**
- Stores employee information.
- Supports employee CRUD operations.

**Customer**
- Stores customer information.
- Can be associated with subscriptions.

**Subscription**
- Stores subscription plan, status, start date, and end date.
- References a customer through a foreign key.

### Subscription Relationship

```text
Customer
   |
   | One customer can have multiple subscriptions
   |
   v
Subscription
```

The subscription table may contain the following fields:

| Column | Description |
|---|---|
| `id` | Subscription primary key |
| `customer_id` | Reference to the customer |
| `plan` | Subscription plan |
| `status` | Subscription status |
| `start_date` | Subscription start date |
| `end_date` | Optional subscription end date |

The actual database schema must match the entity mappings and configured database.

## 9. Database Migrations

If Flyway is configured, versioned SQL migration files can be stored under:

```text
src/main/resources/db/migration/
```

Example migration filename:

```text
V1__create_subscriptions_table.sql
```

Example SQL:

```sql
CREATE TABLE subscriptions (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    plan VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    CONSTRAINT fk_subscription_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers(id)
);
```

**Important:** Confirm that the `customers` table exists and has an `id` primary key before running this migration. Use SQL compatible with the configured database.

Flyway must be included and configured in the project for the migration to execute automatically. Creating a SQL file alone does not execute it.

## 10. Validation and Exception Handling

The application uses Jakarta Validation and centralized exception handling to provide predictable API responses.

Validation may cover:
- Missing required fields.
- Invalid email addresses.
- Invalid salary values.
- Missing customer IDs.
- Missing subscription plans.
- Missing subscription start dates.

Custom exceptions may include:
- `EmployeeNotFoundException`
- `CustomerNotFoundException`
- `DuplicateCustomerException`
- `SubscriptionNotFoundException`

A global exception handler can translate application exceptions into appropriate HTTP responses.

### Example: Validation Error

```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "validationErrors": {
    "customerId": "Customer ID is required"
  },
  "timestamp": "2026-10-30T12:31:38"
}
```

The actual response fields and timestamp format depend on the `ApiError` implementation.

### Common HTTP Status Codes

| Status | Meaning |
|---|---|
| 200 OK | Request completed successfully |
| 201 Created | Resource created successfully |
| 400 Bad Request | Invalid request or validation failure |
| 401 Unauthorized | Authentication is required or failed |
| 403 Forbidden | Access is denied |
| 404 Not Found | Requested resource does not exist |
| 409 Conflict | Duplicate resource or conflicting operation |
| 500 Internal Server Error | Unexpected server-side failure |

## 11. Security

If Spring Security is enabled, protected endpoints require authentication according to the configured security rules.

The health endpoint may be configured for public access:

```http
GET /api/health
```

Use development credentials only in a local test environment. Do not commit real passwords, tokens, or other secrets to GitHub.

For a deployed application, configure secure authentication, appropriate authorization rules, and externally managed credentials.

## 12. Testing

Testing should cover unit-level business logic and API behavior.

### Testing Areas

- Employee creation and retrieval.
- Employee update and deletion.
- Customer creation and duplicate email validation.
- Subscription creation for an existing customer.
- Handling of missing customer IDs.
- Request validation failures.
- Structured exception responses.
- Authentication and authorization boundaries.
- Database persistence and constraints.
- Transaction rollback when an operation fails.

### Run Tests

On Windows, from the project directory, run:

```powershell
.\mvnw.cmd clean test
```

If the project does not include the Maven Wrapper, use:

```powershell
mvn clean test
```

The test command should complete successfully before the project is considered ready.

**Note:** Testcontainers-based PostgreSQL integration tests require Testcontainers configuration and an available Docker environment. Use the test setup documented for your project.

## 13. Running the Application

### Prerequisites

- JDK 17 or a compatible configured Java version.
- Maven or the Maven Wrapper.
- IntelliJ IDEA or another Java IDE.
- Postman for API testing.
- A configured H2 or PostgreSQL database.

### Step 1: Clone the Repository

```bash
git clone https://github.com/shivanigangapuram51-ctrl/java-backend-development.git
```

### Step 2: Open the Project

Open the repository in IntelliJ IDEA and select the `employee_management_api` project directory.

### Step 3: Configure the Database

Check `src/main/resources/application.properties` and configure the appropriate database connection.

Do not commit database passwords or other secrets.

### Step 4: Build the Application

```powershell
.\mvnw.cmd clean package
```

If Maven Wrapper is unavailable:

```powershell
mvn clean package
```

### Step 5: Run the Application

Run `EmployeeManagementApiApplication.java` from IntelliJ IDEA.

Alternatively, if the Maven build produces the expected executable Spring Boot JAR:

```powershell
java -jar target/employee_management_api-0.0.1-SNAPSHOT.jar
```

Replace the JAR filename with the actual filename produced by your build.

### Step 6: Test the APIs

Use Postman to test the employee, customer, subscription, and health endpoints.

The default local server URL is:

```text
http://localhost:8080
```

## 14. Git Workflow

Use Git to version source code, configuration, documentation, and tests.

Check the working tree:

```bash
git status
```

Stage the intended project changes:

```bash
git add .
```

Commit with a descriptive message:

```bash
git commit -m "Complete customer and subscription management APIs"
```

Push to the configured remote branch:

```bash
git push
```

Run these commands from the repository root when working with the combined repository.

Before committing, verify that secrets, generated build files, and local database files are not included.

## 15. Sprint Summary

### Sprint 1: Employee Management API

**Duration:** 12 October 2026 – 16 October 2026

Focus areas:
- Spring Boot setup and dependency injection.
- REST API development and DTO validation.
- JPA persistence and CRUD operations.
- Business rules, exception handling, and tests.
- Integration, documentation, and build verification.

### Sprint 2: SaaS Customer and Subscription Backend

**Duration:** 19 October 2026 – 23 October 2026

Focus areas:
- Layered architecture and dependency injection.
- JPA relationships, pagination, and sorting.
- Transactions, validation, and consistent errors.
- Security and integration testing.
- Customer/subscription workflow, migrations, and API documentation.

## 16. Definition of Done

The project is considered complete when:

- The required REST endpoints are implemented.
- Controller, service, repository, and entity responsibilities are separated.
- Request DTOs and validation rules are implemented.
- Database persistence works with the configured database.
- Missing resources and invalid requests return structured errors.
- Security rules are tested where applicable.
- Unit and integration tests cover important success and failure paths.
- Database migrations are configured where required.
- README instructions match the delivered implementation.
- `mvn clean test` and `mvn package` complete successfully.
- Changes are committed to the assigned Git repository.
- The application can be demonstrated from a documented development environment.

## 17. Conclusion

This project demonstrates practical Java backend development using Spring Boot. It combines employee CRUD operations with customer and subscription management while applying layered architecture, dependency injection, validation, persistence, centralized exception handling, security, and automated testing.

The project provides a foundation for building maintainable REST services and extending them into larger SaaS applications.