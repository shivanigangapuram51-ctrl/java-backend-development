package com.saas.employee_management_api.controller;

import com.saas.employee_management_api.dto.CustomerRequest;
import com.saas.employee_management_api.entity.Customer;
import com.saas.employee_management_api.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Constructor dependency injection
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(
            @Valid @RequestBody CustomerRequest request) {

        Customer customer = customerService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable Long id) {

        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }
}

