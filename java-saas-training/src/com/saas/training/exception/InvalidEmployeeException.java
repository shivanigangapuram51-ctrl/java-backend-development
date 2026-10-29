//EPIC 02,DAY 4,TASK 10
package com.saas.training.exception;

public class InvalidEmployeeException extends RuntimeException{
    public InvalidEmployeeException(String message) {
        super(message);
    }
}
