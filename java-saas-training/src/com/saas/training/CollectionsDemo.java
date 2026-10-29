//EPIC 01, TASK 16,DAY 5
package com.saas.training;
import com.saas.training.model.Employee;
import java.util.*;
public class CollectionsDemo {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Map<Long, Employee> employeeMap = new HashMap<>();
        Set<String> departments = new HashSet<>();
        Map<String, List<Employee>> departmentEmployees =
                new HashMap<>();
        Employee e1 = new Employee(
                101L, "Shivani", "shivani@example.com", 30000
        );

        Employee e2 = new Employee(
                102L, "Rahul", "rahul@example.com", 35000

        );
        Employee e3 = new Employee(
                103L, "Shiva", "Shiva@example.com", 33000
        );
        e1.setDepartment("IT");
        e2.setDepartment("HR");
        e3.setDepartment("Manager");

        // 1. ADD employees to List
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println("--- Employees ---");
        for (Employee employee : employees) {
            System.out.println(
                    employee.getId() + " - " + employee.getName()
            );
        }

        // 2. UPDATE employee in List
        employees.set(2, new Employee(
                103L, "Shiva Updated", "shiva@example.com", 38000
        ));

        System.out.println("\n--- After Update ---");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        // 3. SEARCH employee by ID
        System.out.println("\n--- Search by ID ---");
        for (Employee employee : employees) {
            if (employee.getId().equals(103L)) {
                System.out.println("Found: " + employee.getName());
            }
        }

        // 4. SORT employees by ID
        employees.sort(Comparator.comparing(Employee::getId));

        System.out.println("\n--- Sorted Employees ---");
        for (Employee employee : employees) {
            System.out.println(employee.getId());
        }

        // 5. REMOVE employee from List
        employees.removeIf(
                employee -> employee.getId().equals(102L)
        );

        System.out.println("\n--- After Remove ---");
        System.out.println("List size: " + employees.size());

        // 6. SET prevents duplicate department names
        departments.add("IT");
        departments.add("HR");
        departments.add("Manager");

        System.out.println("\n--- Unique Departments ---");
        System.out.println(departments);

        // 7. MAP: Employee ID -> Employee
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println("\n--- Search in Map ---");
        System.out.println(employeeMap.get(103L).getName());

        // Update employee in Map
        employeeMap.put(
                102L,
                new Employee(
                        102L, " Rahul Updated",
                        " Rahul@example.com", 35000
                )
        );

        System.out.println("\n--- Updated Map Employee ---");
        System.out.println(employeeMap.get(103L).getName());

        // Remove employee from Map
        employeeMap.remove(101L);
        System.out.println("Map size after remove: "
                + employeeMap.size());

        // 8. MAP: Department -> List of Employees
        departmentEmployees.put("IT", new ArrayList<>());
        departmentEmployees.put("HR", new ArrayList<>());
        departmentEmployees.put("Manager",new ArrayList<>());

        departmentEmployees.get("IT").add(e1);
        departmentEmployees.get("HR").add(e2);
        departmentEmployees.get("Manager").add(e3);

        System.out.println("\n--- Employees by Department ---");
        for (String department : departmentEmployees.keySet()) {
            System.out.println(
                    department + ": "
                            + departmentEmployees.get(department).size()
                            + " employee(s)"
            );
        }
    }
}


