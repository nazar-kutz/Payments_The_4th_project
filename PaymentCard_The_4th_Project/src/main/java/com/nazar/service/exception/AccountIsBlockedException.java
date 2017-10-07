package com.nazar.service.exception;

public class AccountIsBlockedException extends RuntimeException {
    private String message = "Account is blocked";

    @Override
    public String getMessage() {
        return message;
    }

    public AccountIsBlockedException(Exception e) {
        super(e);
    }

    public AccountIsBlockedException() {}
}
