package com.saas.employee_management_api.repository;

import com.saas.employee_management_api.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository
        extends JpaRepository<Subscription, Long> {

    List<Subscription> findByCustomerId(Long customerId);
}