//EPIC 03,DAY 1
package com.saas.employee_management_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public String health() {
        return "Employee Management API is running!";
    }
}
