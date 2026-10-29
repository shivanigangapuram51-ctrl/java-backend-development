package com.saas.training.util;

import com.saas.training.model.SubscriptionPlan;

public final class SubscriptionUtil {

    private SubscriptionUtil() {
    }

    public static int getEmployeeLimit(SubscriptionPlan plan) {
        switch (plan) {
            case FREE:
                return 5;
            case BASIC:
                return 25;
            case PRO:
                return 100;
            case ENTERPRISE:
                return SaaSConstants.MAX_EMPLOYEES;
            default:
                throw new IllegalArgumentException(
                        "Unsupported subscription plan");
        }
    }
}
