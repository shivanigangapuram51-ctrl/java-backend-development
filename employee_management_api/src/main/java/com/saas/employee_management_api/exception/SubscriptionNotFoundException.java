package com.saas.employee_management_api.exception;

public class SubscriptionNotFoundException extends RuntimeException {

    public SubscriptionNotFoundException(Long id) {
        super("Subscription not found with ID: " + id);
    }
}
