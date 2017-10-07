package com.nazar.service.exception;

public class UserNotExistException extends RuntimeException {
    private String message = "Not correct login or password";

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotExistException(Exception e) {
        super(e);
    }
}
