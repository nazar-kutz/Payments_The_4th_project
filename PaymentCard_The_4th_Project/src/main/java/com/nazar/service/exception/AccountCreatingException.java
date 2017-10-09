package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_ACCOUNT_CREATING;

public class AccountCreatingException extends RuntimeException {
    private String message = ERR_ACCOUNT_CREATING;

    @Override
    public String getMessage() {
        return message;
    }

    public AccountCreatingException(Exception e) {
        super(e);
    }
}
