//EPIC 01,TASK 15,DAY 4
package com.saas.training.notification;

public class
             EmailNotificationService
        implements NotificationService {

    @Override
    public void sendEmail() {
        System.out.println("Email sent successfully");
    }

    @Override
    public void sendNotification() {
        System.out.println("Email notification sent");
    }
}
