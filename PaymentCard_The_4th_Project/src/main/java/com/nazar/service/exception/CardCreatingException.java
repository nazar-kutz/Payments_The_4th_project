package com.nazar.service.exception;

public class CardCreatingException extends RuntimeException{
    private String message = "Can't create card";

    @Override
    public String getMessage() {
        return message;
    }

    public CardCreatingException(Exception e) {
        super(e);
    }
}
