package com.saas.training.util;

import com.saas.training.exception.InvalidSubscriptionException;

public class OrganizationValidator {

    public static void validateOrganizationName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Organization name cannot be blank"
            );
        }
    }

    public static void validateSubscriptionPlan(String plan) {
        if (plan == null || plan.isBlank()) {
            throw new InvalidSubscriptionException(
                    "Subscription plan is required"
            );
        }

        try {
            com.saas.training.model.SubscriptionPlan.valueOf(
                    plan.trim().toUpperCase()
            );
        } catch (IllegalArgumentException e) {
            throw new InvalidSubscriptionException(
                    "Invalid subscription plan: " + plan
            );
        }
    }
}
