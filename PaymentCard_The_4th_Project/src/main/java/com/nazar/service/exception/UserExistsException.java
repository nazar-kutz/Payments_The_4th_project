package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_USER_EXISTS;

public class UserExistsException extends RuntimeException{
    private String message = ERR_USER_EXISTS;

    @Override
    public String getMessage() {
        return message;
    }

    public UserExistsException(String login){
        message += ":" + login;
    }
}
