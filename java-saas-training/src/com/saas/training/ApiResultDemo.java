package com.saas.training;

import com.saas.training.model.ApiResult;
import com.saas.training.model.Employee;

import java.util.Arrays;
import java.util.List;

public class ApiResultDemo {

    public static void main(String[] args) {

        Employee employee =
                new Employee(101L, "Shivani");

        // One Employee
        ApiResult<Employee> employeeResult =
                new ApiResult<>(
                        true, "Employee found", employee);

        System.out.println(employeeResult);

        // List of Employees
        List<Employee> employees = Arrays.asList(
                new Employee(101L, "Shivani"),
                new Employee(102L, "Rahul"),
                new Employee(103L, "shiva")

        );

        ApiResult<List<Employee>> listResult =
                new ApiResult<>(
                        true, "Employees found", employees);

        System.out.println(listResult);

        // String message
        ApiResult<String> messageResult =
                new ApiResult<>(
                        true, "Success", "Employee created");

        System.out.println(messageResult);
    }
}

