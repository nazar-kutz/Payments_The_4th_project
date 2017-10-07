package com.nazar.service.exception;

public class UserExistsException extends RuntimeException{
    private String message = "User with this login already exists";

    @Override
    public String getMessage() {
        return message;
    }

    public UserExistsException(Exception e){
        super(e);
    }

    public UserExistsException() {
    }
}
