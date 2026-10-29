//EPIC 01,DAY 04,TASK 15
package com.saas.training.notification;

public class SMSNotificationService
        implements NotificationService {

    @Override
    public void sendEmail() {
        System.out.println("Email is not supported by SMS service");
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS notification sent successfully");
    }
}



