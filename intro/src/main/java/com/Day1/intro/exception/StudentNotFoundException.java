package com.Day1.intro.exception;

public class StudentNotFoundException extends RuntimeException{
    private String message;

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public StudentNotFoundException() {

    }
}
