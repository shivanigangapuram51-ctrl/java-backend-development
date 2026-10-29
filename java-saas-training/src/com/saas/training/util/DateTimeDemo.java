package com.saas.training.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeDemo {

    public static void main(String[] args) {

        Integer employeeCount = 50;
        Long employeeId = 101L;
        Double salary = 30000.0;
        Boolean active = true;

        LocalDate joiningDate =
                LocalDate.of(2026, 10, 14);

        LocalDateTime subscriptionStart =
                LocalDateTime.now();

        LocalDate subscriptionExpiry =
                joiningDate.plusMonths(12);

        System.out.println("Employee count: " + employeeCount);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Active: " + active);
        System.out.println("Joining date: " + joiningDate);
        System.out.println("Subscription start: " + subscriptionStart);
        System.out.println("Subscription expiry: " + subscriptionExpiry);
    }
}