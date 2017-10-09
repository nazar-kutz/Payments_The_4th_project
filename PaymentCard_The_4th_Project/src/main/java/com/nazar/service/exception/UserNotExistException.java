package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_USER_NOT_EXISTS;

public class UserNotExistException extends RuntimeException {
    private String message = ERR_USER_NOT_EXISTS;

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotExistException(Exception e) {
        super(e);
    }
}
