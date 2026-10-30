package com.saas.employee_management_api.service;

import com.saas.employee_management_api.dto.CustomerRequest;
import com.saas.employee_management_api.entity.Customer;
import com.saas.employee_management_api.exception.CustomerNotFoundException;
import com.saas.employee_management_api.exception.DuplicateCustomerException;
import com.saas.employee_management_api.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Constructor dependency injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create a new customer
    @Transactional
    public Customer createCustomer(CustomerRequest request) {

        String name = request.getName().trim();
        String email = request.getEmail().trim();

        // Check for duplicate email
        if (customerRepository.existsByEmailIgnoreCase(email)) {
            throw new DuplicateCustomerException(email);
        }

        // Create and save the customer
        Customer customer = new Customer(name, email);

        return customerRepository.saveAndFlush(customer);
    }

    // Get customer by ID
    @Transactional(readOnly = true)
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    // Get all customers
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }
}