package com.saas.employee_management_api.service;

import com.saas.employee_management_api.dto.SubscriptionRequest;
import com.saas.employee_management_api.entity.Customer;
import com.saas.employee_management_api.entity.Subscription;
import com.saas.employee_management_api.enums.SubscriptionStatus;
import com.saas.employee_management_api.exception.CustomerNotFoundException;
import com.saas.employee_management_api.exception.SubscriptionNotFoundException;
import com.saas.employee_management_api.repository.CustomerRepository;
import com.saas.employee_management_api.repository.SubscriptionRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final CustomerRepository customerRepository;

    public SubscriptionService(
            SubscriptionRepository subscriptionRepository,
            CustomerRepository customerRepository) {

        this.subscriptionRepository = subscriptionRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Subscription createSubscription(SubscriptionRequest request) {

        if (request.getEndDate() != null
                && request.getEndDate().isBefore(request.getStartDate())) {
            throw new IllegalArgumentException(
                    "End date cannot be earlier than start date."
            );
        }

        Customer customer = customerRepository
                .findById(request.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(request.getCustomerId())
                );

        Subscription subscription = new Subscription(
                customer,
                request.getPlan(),
                request.getStartDate(),
                request.getEndDate()
        );

        return subscriptionRepository.save(subscription);
    }

    @Transactional(readOnly = true)
    public Subscription getSubscriptionById(Long id) {

        return subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new SubscriptionNotFoundException(id)
                );
    }

    @Transactional(readOnly = true)
    public List<Subscription> getSubscriptionsByCustomer(Long customerId) {

        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        return subscriptionRepository.findByCustomerId(customerId);
    }

    @Transactional
    public Subscription updateSubscriptionStatus(
            Long id,
            SubscriptionStatus status) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new SubscriptionNotFoundException(id)
                );

        subscription.setStatus(status);

        return subscriptionRepository.save(subscription);
    }
}
