package com.example.employeemanager.exception;

public class UseNotFoundException extends  RuntimeException{
    public UseNotFoundException(String message) {
        super(message);
    }
}
