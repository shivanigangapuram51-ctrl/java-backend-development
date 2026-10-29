package com.saas.training;

import com.saas.training.model.User;
import com.saas.training.model.Employee;
import com.saas.training.model.HR;
import com.saas.training.model.Admin;
import com.saas.training.model.Organization;
import com.saas.training.model.Department;
import com.saas.training.model.Subscription;
import com.saas.training.model.EmployeeStatus;
import com.saas.training.model.SubscriptionPlan;

import com.saas.training.notification.NotificationService;
import com.saas.training.notification.EmailNotificationService;
import com.saas.training.notification.SMSNotificationService;

import com.saas.training.repository.EmployeeRepository;
import com.saas.training.service.EmployeeService;
import com.saas.training.util.EmployeeValidator;
import com.saas.training.util.SubscriptionUtil;


public class Main {

    public static void main(String[] args) {

        try {
            EmployeeValidator.validateName("Shivani");
            EmployeeValidator.validateEmail("shivani@example.com");
            EmployeeValidator.validateSalary(30000);

            System.out.println("Employee details are valid.");

        } catch (RuntimeException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        EmployeeRepository repository = new EmployeeRepository();

        EmployeeService service = new EmployeeService(repository);

        // EPIC 01,DAY1 ,TASK 1: Java SaaS Training Started
        System.out.println("Java SaaS Training Started");

        // EPIC 01,DAY1 TASK 2: Variables and Data Types
        String companyName = "ABC Technologies";
        String adminName = "Rahul";
        int employeeCount = 50;
        double subscriptionAmount = 4999.00;
        boolean active = true;

        System.out.println("\n--- Task 2: Company Details ---");
        System.out.println("Company: " + companyName);
        System.out.println("Admin: " + adminName);
        System.out.println("Employees: " + employeeCount);
        System.out.println("Subscription: " + subscriptionAmount);
        System.out.println("Active: " + active);

        // DAY1 TASK 2: Enums and Subscription Limits
        EmployeeStatus status = EmployeeStatus.ACTIVE;
        SubscriptionPlan plan = SubscriptionPlan.PRO;

        System.out.println("Employee Status: " + status);
        System.out.println("Subscription Plan: " + plan);
        System.out.println(
                "Employee Limit: "
                        + SubscriptionUtil.getEmployeeLimit(plan)
        );

        // DAY 1 TASK 3: Operators
        double subscriptionPrice = 4999.00;
        double addOnPrice = 1000.00;
        double discount = 500.00;

        double finalAmount =
                subscriptionPrice + addOnPrice - discount;

        System.out.println("\n--- Task 3: Operators ---");
        System.out.println("Final Amount: " + finalAmount);
        System.out.println(
                "More than 10 employees: " + (employeeCount > 10)
        );
        System.out.println(
                "Employee count is 50: " + (employeeCount == 50)
        );
        System.out.println(
                "Active and more than 10 employees: "
                        + (active && employeeCount > 10)
        );

        int count = 10;
        count += 5;
        System.out.println("Updated Count: " + count);

        // DAY 2 TASK_4: Conditional Statements
        System.out.println("\n--- Task 4: Employee Status ---");

        checkEmployeeStatus("ACTIVE");
        checkEmployeeStatus("INACTIVE");
        checkEmployeeStatus("ON_LEAVE");
        checkEmployeeStatus("TERMINATED");

        // EPIC 01,DAY 2 TASK 5: Switch Statement
        System.out.println("\n--- Task 5: Subscription Plans ---");

        showSubscriptionFeatures("FREE");
        showSubscriptionFeatures("BASIC");
        showSubscriptionFeatures("PRO");
        showSubscriptionFeatures("ENTERPRISE");

        //EPIC 01, DAY 2 TASK 6: Loops
        System.out.println("\n--- Task 6: All Employees ---");
        printEmployees();

        System.out.println("\n--- Active Employees ---");
        printActiveEmployees();

        System.out.println("\n--- While Loop ---");
        printUsingWhile();

        System.out.println("\n--- Do-While Loop ---");
        printUsingDoWhile();

        // DAY 2 TASK 7: Methods
        System.out.println("\n--- Task 7: Salary Calculation ---");

        double grossSalary = calculateSalary(30000, 5000);
        double tax = calculateTax(grossSalary);
        double netSalary = calculateNetSalary(grossSalary, tax);

        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Salary: " + netSalary);

        double calculatedSubscription =
                calculateSubscription(4999, 1000, 500);

        System.out.println(
                "Calculated Subscription: " + calculatedSubscription
        );

        // DAY 3 TASK 8: Employee Object
        Employee employee = new Employee();

        employee.setId(101L);
        employee.setName("Shivani");
        employee.setEmail("shivani@example.com");
        employee.setPhone("9876543210");
        employee.setSalary(30000.0);
        employee.setDepartment("IT");
        employee.setStatus("ACTIVE");

        System.out.println("\n--- Task 8: Employee Details ---");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone: " + employee.getPhone());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Status: " + employee.getStatus());

        // DAY 3 TASK 9: Constructor Overloading
        Employee employee1 = new Employee();
        employee1.setId(101L);
        employee1.setName("Shivani");

        Employee employee2 = new Employee(102L, "Rahul");

        Employee employee3 = new Employee(
                103L,
                "Priya",
                "priya@example.com",
                40000.0
        );

        System.out.println("\n--- Task 9: Constructors ---");
        System.out.println(
                "Employee 1: "
                        + employee1.getId() + ", "
                        + employee1.getName()
        );
        System.out.println(
                "Employee 2: "
                        + employee2.getId() + ", "
                        + employee2.getName()
        );
        System.out.println(
                "Employee 3: "
                        + employee3.getId() + ", "
                        + employee3.getName() + ", "
                        + employee3.getEmail() + ", "
                        + employee3.getSalary()
        );

        //DAY3 TASK 10: Encapsulation and Validation
        System.out.println("\n--- Task 10: Encapsulation ---");

        try {
            employee.setSalary(-5000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation: " + e.getMessage());
        }

        System.out.println(
                "Employee salary remains: " + employee.getSalary()
        );

        // DAY 3 TASK 11: SaaS Domain Classes
        System.out.println("\n--- Task 11: SaaS Domain Classes ---");

        Organization organization =
                new Organization(1L, "ABC Technologies");

        Employee newEmployee = new Employee(
                201L,
                "Rahul",
                "rahul@example.com",
                35000.0
        );

        Department department = new Department(1L, "IT");

        department.addEmployee(newEmployee);
        organization.addEmployee(newEmployee);
        organization.addDepartment(department);

        Subscription subscription =
                new Subscription(1L, "PRO", 4999.0, "ACTIVE");

        organization.setSubscription(subscription);

        System.out.println("Organization: " + organization.getName());
        System.out.println(
                "Employees: " + organization.getEmployees().size()
        );
        System.out.println(
                "Departments: " + organization.getDepartments().size()
        );
        System.out.println(
                "Subscription Plan: "
                        + organization.getSubscription().getPlanName()
        );

        // DAY 4 TASKS 12-14: Inheritance, Overriding and Abstraction
        System.out.println("\n--- Tasks 12-14: OOP ---");

        User employeeUser = new Employee(104L, "Shivani");
        User hrUser = new HR(
                105L, "Priya", "priya@example.com"
        );
        User adminUser = new Admin(
                106L, "Rahul", "rahul@example.com"
        );

        User[] users = {employeeUser, hrUser, adminUser};

        for (User user : users) {
            System.out.println("Role: " + user.getRole());
            user.showPermissions();
        }

        // DAY 4 TASK 15: Interfaces
        System.out.println("\n--- Task 15: Interfaces ---");

        NotificationService emailService =
                new EmailNotificationService();

        NotificationService smsService =
                new SMSNotificationService();

        emailService.sendEmail();
        emailService.sendNotification();

        smsService.sendEmail();
        smsService.sendNotification();
    }

    // DAY 2 TASK 4: Check Employee Status
    static void checkEmployeeStatus(String status) {

        if (status.equals("ACTIVE")) {
            System.out.println("Employee is active");
        } else if (status.equals("INACTIVE")) {
            System.out.println("Employee is inactive");
        } else if (status.equals("ON_LEAVE")) {
            System.out.println("Employee is on leave");
        } else if (status.equals("TERMINATED")) {
            System.out.println("Employee is terminated");
        } else {
            System.out.println("Invalid employee status");
        }
    }

    // DAY  2 TASK 5: Subscription Plan Features
    static void showSubscriptionFeatures(String plan) {

        switch (plan) {
            case "FREE":
                System.out.println("FREE -> Limited Features");
                break;

            case "BASIC":
                System.out.println("BASIC -> Employee Management");
                break;

            case "PRO":
                System.out.println("PRO -> Employee + Payroll");
                break;

            case "ENTERPRISE":
                System.out.println("ENTERPRISE -> All Features");
                break;

            default:
                System.out.println("Invalid subscription plan");
        }
    }

    // DAY 2 TASK 6: Print Employees
    static void printEmployees() {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Employee " + i);
        }
    }

    // DAY 2 TASK 6: Print Active Employees
    static void printActiveEmployees() {

        String[] statuses = {
                "ACTIVE", "INACTIVE", "ACTIVE", "ON_LEAVE",
                "ACTIVE", "TERMINATED", "INACTIVE", "ACTIVE",
                "ON_LEAVE", "ACTIVE"
        };

        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i].equals("ACTIVE")) {
                System.out.println(
                        "Employee " + (i + 1) + " is active"
                );
            }
        }
    }

    // DAY 2 TASK 6: While Loop
    static void printUsingWhile() {

        int count = 1;

        while (count <= 3) {
            System.out.println(count);
            count++;
        }
    }

    // DAY 2 TASK 6: Do-While Loop
    static void printUsingDoWhile() {

        int count = 1;

        do {
            System.out.println(count);
            count++;
        } while (count <= 3);
    }

    // DAY 2 TASK 7: Calculate Gross Salary
    static double calculateSalary(
            double basicSalary, double allowance) {

        return basicSalary + allowance;
    }

    // DAY 2 TASK 7: Calculate Tax
    static double calculateTax(double salary) {

        return salary * 0.10;
    }

    // DAY 2 TASK 7: Calculate Net Salary
    static double calculateNetSalary(double salary, double tax) {

        return salary - tax;
    }

    // DAY 2 TASK 7: Calculate Subscription
    static double calculateSubscription(
            double subscriptionPrice,
            double addOnPrice,
                
            double discount) {

        return subscriptionPrice + addOnPrice - discount;
    }
}

