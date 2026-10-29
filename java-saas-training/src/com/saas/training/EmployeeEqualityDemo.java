
package com.saas.training;
import com.saas.training.model.Employee;
import java.util.HashSet;
import java.util.Set;

public class EmployeeEqualityDemo {

    public static void main(String[] args) {

        Employee e1 = new Employee(
                101L, "Shivani", "shivani@example.com", 30000
        );

        Employee e2 = new Employee(
                101L, "Shivani", "shivani@example.com", 30000
        );

        System.out.println("Equal:  " + e1.equals(e2));

        Set<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);

        System.out.println("Set size: " + employees.size());

        System.out.println(e1);
    }
}

