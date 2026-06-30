package com.spring.spring_rest.entity;

public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -269010004608797236L;

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}