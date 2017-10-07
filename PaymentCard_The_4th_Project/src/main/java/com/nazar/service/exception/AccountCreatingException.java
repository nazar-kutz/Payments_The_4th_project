package com.nazar.service.exception;

public class AccountCreatingException extends RuntimeException {
    private String message = "Can't create an account";

    @Override
    public String getMessage() {
        return message;
    }

    public AccountCreatingException(Exception e) {
        super(e);
    }
}
