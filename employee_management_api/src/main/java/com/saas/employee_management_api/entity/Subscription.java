package com.saas.employee_management_api.entity;

import com.saas.employee_management_api.enums.SubscriptionPlan;
import com.saas.employee_management_api.enums.SubscriptionStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscriptionPlan plan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscriptionStatus status;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    public Subscription() {
    }

    public Subscription(
            Customer customer,
            SubscriptionPlan plan,
            LocalDate startDate,
            LocalDate endDate) {

        this.customer = customer;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = SubscriptionStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public SubscriptionPlan getPlan() {
        return plan;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setPlan(SubscriptionPlan plan) {
        this.plan = plan;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
