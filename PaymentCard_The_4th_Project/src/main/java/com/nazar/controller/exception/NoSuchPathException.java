package com.nazar.controller.exception;

public class NoSuchPathException extends RuntimeException {
    private String message = "No such path: ";

    @Override
    public String getMessage() {
        return message;
    }

    public NoSuchPathException(Exception e) {
        super(e);
    }

    public NoSuchPathException() {
    }

    public NoSuchPathException(String message) {
        this.message += message;
    }
}
