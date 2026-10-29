
package com.saas.training;

import com.saas.training.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeOperation {

    public static void main(String[] args) {

        // Create employee list
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee(
                101L, "Rahul", "rahul@example.com", 30000);
        e1.setDepartment("IT");
        e1.setStatus("ACTIVE");

        Employee e2 = new Employee(
                102L, "Priya", "priya@example.com", 45000);
        e2.setDepartment("HR");
        e2.setStatus("ACTIVE");

        Employee e3 = new Employee(
                103L, "Arun", "arun@example.com", 25000);
        e3.setDepartment("IT");
        e3.setStatus("INACTIVE");

        Employee e4 = new Employee(
                104L, "Sneha", "sneha@example.com", 40000);
        e4.setDepartment("Finance");
        e4.setStatus("ACTIVE");

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        // TASK 7: LAMBDA EXPRESSIONS

        // 1. Filter active employees
        List<Employee> activeEmployees = employees.stream()
                .filter(e -> "ACTIVE".equals(e.getStatus()))
                .toList();

        System.out.println("Active Employees:");
        activeEmployees.forEach(System.out::println);

        // 2. Sort employees by salary (low to high)
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();

        System.out.println("\nEmployees Sorted by Salary:");
        sortedBySalary.forEach(System.out::println);

        // 3. Find employees in IT department
        List<Employee> itEmployees = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .toList();

        System.out.println("\nIT Employees:");
        itEmployees.forEach(System.out::println);

        // TASK 8: STREAM API

        // 4. Count active employees
        long activeCount = employees.stream()
                .filter(e -> "ACTIVE".equals(e.getStatus()))
                .count();

        System.out.println("\nActive Employee Count: " + activeCount);

        // 5. Find highest salary
        OptionalDouble highestSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();

        System.out.println("Highest Salary: "
                + highestSalary.orElse(0.0));

        // 6. Group employees by department
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees By Department:");
        byDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });

        // 7. Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Salary: " + averageSalary);

        // 8. Employees earning above 30000
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary() > 30000)
                .toList();

        System.out.println("\nEmployees Earning Above 30000:");
        highSalaryEmployees.forEach(System.out::println);

        // 9. Check whether any employee belongs to HR
        boolean hasHrEmployee = employees.stream()
                .anyMatch(e -> "HR".equals(e.getDepartment()));

        System.out.println("\nHas HR Employee: " + hasHrEmployee);

        // 10. Check whether all employees have valid salaries
        boolean allValidSalaries = employees.stream()
                .allMatch(e -> e.getSalary() >= 0);

        System.out.println("All Salaries Valid: " + allValidSalaries);

        // 11. Find the first employee
        Optional<Employee> firstEmployee = employees.stream()
                .findFirst();

        System.out.println("\nFirst Employee:");
        firstEmployee.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No employees found"));

    }
}

