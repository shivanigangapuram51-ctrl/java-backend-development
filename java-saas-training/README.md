# Java SaaS Training Project

## 1. Project Overview

The Java SaaS Training Project is a learning project designed to develop Java programming and backend development skills. It focuses on building the business logic for a Software-as-a-Service (SaaS) Employee Management System.

The project starts with Java fundamentals and gradually introduces object-oriented programming, collections, exception handling, validation, Maven, and layered architecture.

The final application manages employees and organizations using a structured, maintainable Java backend design.

## 2. Project Objectives

- Understand Java fundamentals and object-oriented programming.
- Implement classes, objects, constructors, and encapsulation.
- Apply inheritance, polymorphism, abstraction, and interfaces.
- Work with Java Collections and Generics.
- Use Lambda Expressions, Stream API, and Optional.
- Implement custom exceptions and input validation.
- Understand Maven project configuration and dependency management.
- Separate business logic into service and repository layers.
- Build an Employee Management System using an in-memory repository.
- Maintain project changes using Git and GitHub.

## 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java 17+ | Programming language |
| IntelliJ IDEA | Development environment |
| Maven | Build and dependency management |
| Git | Version control |
| GitHub | Source code hosting |
| JUnit | Unit testing |

## 4. Project Structure

```text
java-saas-training/
│
├── src/
│   └── com/
│       └── saas/
│           └── training/
│               ├── model/
│               │   ├── User.java
│               │   ├── Employee.java
│               │   ├── Organization.java
│               │   ├── Department.java
│               │   ├── Subscription.java
│               │   ├── EmployeeStatus.java
│               │   └── SubscriptionPlan.java
│               │
│               ├── service/
│               │   ├── EmployeeService.java
│               │   └── OrganizationService.java
│               │
│               ├── repository/
│               │   └── EmployeeRepository.java
│               │
│               ├── notification/
│               │   ├── NotificationService.java
│               │   ├── EmailNotificationService.java
│               │   └── SMSNotificationService.java
│               │
│               ├── exception/
│               │   ├── EmployeeNotFoundException.java
│               │   ├── DuplicateEmployeeException.java
│               │   ├── InvalidEmployeeException.java
│               │   ├── InvalidSalaryException.java
│               │   └── InvalidSubscriptionException.java
│               │
│               ├── util/
│               │   ├── EmployeeValidator.java
│               │   ├── OrganizationValidator.java
│               │   ├── SaaSConstants.java
│               │   └── SubscriptionUtil.java
│               │
│               └── Main.java
│
├── src/test/java/
├── pom.xml
├── README.md
└── .gitignore
```

*Note: This structure represents the intended organization of the project. Some files may be located differently depending on the current implementation.*

## 5. Weekly Implementation

### Week 1: Java Fundamentals and OOP

**Duration:** 28 September 2026 – 2 October 2026

#### Day 1: Java Setup, Variables, Data Types, and Operators

- Created the initial Java training project.
- Configured the JDK and development environment.
- Created the `com.saas.training` package and `Main.java`.
- Practiced variables, primitive data types, and String.
- Implemented arithmetic, comparison, logical, and assignment operators.
- Practiced calculating subscription amounts.

#### Day 2: Conditions, Loops, and Methods

- Practiced conditional statements and switch expressions or statements.
- Implemented employee status checks.
- Developed subscription plan selection logic.
- Practiced `for`, `while`, and `do-while` loops.
- Created reusable methods for salary and subscription calculations.

#### Day 3: Object-Oriented Programming — Part 1

- Created Employee and other SaaS domain classes.
- Implemented constructors and constructor overloading.
- Applied encapsulation using private fields, getters, and setters.
- Added basic salary validation.
- Modelled relationships between organizations, employees, departments, and subscriptions.

#### Day 4: Object-Oriented Programming — Part 2

- Implemented inheritance using a common User class.
- Practiced method overriding and runtime polymorphism.
- Used abstract classes to define common behavior.
- Created notification interfaces and implementations.
- Explored how interfaces support flexible application design.

#### Day 5: Collections, Exceptions, and Mini Project

- Practiced `ArrayList`, `HashSet`, and `HashMap`.
- Implemented employee creation, searching, updating, and deletion.
- Created custom exceptions for employee and business validation.
- Combined the concepts into a console-based Employee Management System.

### Week 2: Java Backend Structure and Language Features

**Duration:** 5 October 2026 – 9 October 2026

#### Day 1: Packages and Language Features

- Organized classes into model, service, repository, exception, and util packages.
- Practiced access modifiers.
- Implemented enums for employee status and subscription plans.
- Used constants and utility classes.
- Practiced wrapper classes and Java date/time APIs.

#### Day 2: Collections, Generics, and Object Behaviour

- Practiced advanced operations with List, Set, and Map.
- Implemented reusable generic response structures using `ApiResult<T>`.
- Overrode `equals()`, `hashCode()`, and `toString()`.
- Explored duplicate prevention and employee lookup.

#### Day 3: Functional Programming

- Practiced lambda expressions.
- Used Stream API operations such as `filter`, `map`, `sorted`, and `collect`.
- Created employee reports and filtering operations.
- Used Optional for employee search results.

#### Day 4: Exceptions, Validation, and Maven

- Created custom business exceptions.
- Implemented input validation for employee and organization data.
- Converted the project into a Maven-based Java project.
- Learned the purpose of `pom.xml`, dependencies, and build plugins.
- Practiced Maven build and test commands.

#### Day 5: Backend Refactoring

- Organized the project into controller, service, repository, model, exception, and util layers.
- Implemented an in-memory EmployeeRepository using `Map<Long, Employee>`.
- Connected business operations through EmployeeService.
- Practiced employee CRUD operations, filtering, and salary reports.
- Prepared project documentation and Git commits.

*The sections above describe the training plan and intended outcomes. Actual completion should be confirmed against the current source code and test results.*

## 6. Application Features

The intended Employee Management System supports:

- Employee creation.
- Employee listing and searching.
- Employee updates and deletion.
- Employee status management.
- Employee and department organization.
- Salary calculations and reports.
- Subscription plan validation.
- Input validation.
- Custom exception handling.
- Email and SMS notification abstractions.
- Employee filtering using collections and streams.

## 7. Architecture

The application uses a layered design to separate responsibilities.

```text
             Main.java
                 |
                 v
          EmployeeService
                 |
                 v
        EmployeeRepository
                 |
                 v
          In-Memory Map
```

### Main

Provides the application entry point and coordinates the console workflow.

### Model

Contains domain classes such as Employee, User, Organization, Department, and Subscription.

### Service

Contains business logic, employee operations, validation coordination, and business rules.

### Repository

Manages employee data access. The training implementation uses an in-memory `Map<Long, Employee>` instead of a database.

### Exception

Contains custom exceptions used to represent invalid input, missing employees, duplicate employees, and other business errors.

### Util

Contains reusable validation logic, constants, and subscription-related utilities.

### Notification

Defines notification interfaces and implementations for email and SMS behavior.

## 8. Employee Management Flow

The basic employee operation flow is:

1. The application receives an employee operation.
2. The service layer validates the input and applies business rules.
3. The service calls the repository to access employee data.
4. The repository performs the required operation on the in-memory map.
5. The service returns the result or raises an appropriate exception.
6. The application displays the result.

## 9. Validation and Exception Handling

The project uses validation and custom exceptions to handle invalid operations.

Examples include:

- `EmployeeNotFoundException` — an employee cannot be found.
- `DuplicateEmployeeException` — an employee ID or other unique value is duplicated.
- `InvalidEmployeeException` — employee information is invalid.
- `InvalidSalaryException` — a salary violates the business rules.
- `InvalidSubscriptionException` — a subscription plan or operation is invalid.

Validation should be separated from the main application workflow to improve maintainability and reusability.

## 10. Build and Run

### Prerequisites

- JDK 17 or later.
- IntelliJ IDEA or another Java IDE.
- Maven.
- Git.

### Open the Project

1. Open IntelliJ IDEA.
2. Select **File → Open**.
3. Choose the `java-saas-training` folder.
4. Allow IntelliJ to import the Maven project.

### Verify the Java Version

Open a terminal and execute:

```bash
java -version
```

Verify that Java 17 or later is configured.

### Build the Project

Run the following command from the directory containing `pom.xml`:

```bash
mvn clean package
```

### Run the Application

For a Maven project using the standard source layout and a configured main class, run:

```bash
mvn exec:java -Dexec.mainClass="com.saas.training.Main"
```

This command requires the Maven Exec Plugin to be configured in `pom.xml`. Alternatively, open `Main.java` in IntelliJ IDEA and click **Run**.

### Run Tests

Execute:

```bash
mvn test
```

The command runs the tests configured for the Maven project.

## 11. Testing

Testing should cover normal operations and negative or boundary scenarios.

Recommended test cases include:

- Creating an employee with valid details.
- Searching for an existing employee.
- Searching for a nonexistent employee.
- Updating an employee's details.
- Deleting an employee.
- Rejecting invalid salary values.
- Preventing duplicate employees.
- Filtering employees by status.
- Calculating salary reports.
- Validating subscription plans.

Record the actual test results after running the tests.

## 12. Git and GitHub

Git is used to track changes, and GitHub is used to host the source code.

Common commands:

```bash
git status
git add .
git commit -m "Update Java SaaS training project"
git push
```

Run these commands from the appropriate Git repository directory.

## 13. Learning Outcomes

This project is intended to develop practical understanding of:

- Java syntax, variables, and data types.
- Object-oriented programming.
- Collections and Generics.
- Lambda expressions and Stream API.
- Optional and object equality.
- Exception handling and input validation.
- Maven project structure and dependency management.
- Service and repository separation.
- In-memory data storage.
- Version control with Git and GitHub.

## 14. Current Limitations

- Employee data is stored in memory and is not persistent across application restarts.
- The project is a Java training application rather than a complete production SaaS platform.
- Authentication and authorization are not included in the basic console implementation.
- Database integration and Spring Boot REST endpoints are outside the scope of this initial Java mini project.
- Notification implementations may be demonstrations rather than integrations with actual email or SMS providers.
- Automated test coverage depends on the tests currently implemented.

## 15. Future Enhancements

- Introduce Spring Boot REST APIs.
- Replace in-memory storage with a relational database.
- Add Spring Data JPA.
- Implement request validation and centralized API exception handling.
- Add authentication and role-based authorization.
- Implement automated unit and integration tests.
- Introduce organization-level data isolation for multi-tenant SaaS behavior.
- Add employee and department pagination and sorting.

## 16. Conclusion

The Java SaaS Training Project provides a foundation for Java backend development through an Employee Management System. It progresses from fundamental Java concepts to object-oriented design, collections, validation, exception handling, Maven, and layered architecture.

The project prepares for further development with Spring Boot, REST APIs, database persistence, testing, and SaaS application architecture.