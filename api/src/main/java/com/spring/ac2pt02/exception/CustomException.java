package com.spring.ac2pt02.exception;

public class CustomException extends RuntimeException {
    private final int errorCode;
    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
