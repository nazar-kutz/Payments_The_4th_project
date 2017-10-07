package com.nazar.service.exception;

public class NoSuchAccountException extends RuntimeException{
    private String message = "No such account";

    public NoSuchAccountException(int accountId) {
        this.message += ": " + accountId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public NoSuchAccountException(Exception e) {
        super(e);
    }
}
