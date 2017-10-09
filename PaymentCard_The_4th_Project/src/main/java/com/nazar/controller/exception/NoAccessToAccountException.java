package com.nazar.controller.exception;

import static com.nazar.language.StringGlobalConstants.ERR_NO_ACCESS_TO_ACCOUNT;

public class NoAccessToAccountException extends RuntimeException {
    String message = ERR_NO_ACCESS_TO_ACCOUNT;

    public NoAccessToAccountException(long accountId){
        message += ":" + accountId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
