package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_NO_SUCH_ACCOUNT;

public class NoSuchAccountException extends RuntimeException{
    private String message = ERR_NO_SUCH_ACCOUNT;

    public NoSuchAccountException(int accountId) {
        this.message += ": " + accountId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public NoSuchAccountException(long accountId) {
        message += ":" + accountId;
    }
}
