package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_ACCOUNT_IS_BLOCKED;

public class AccountIsBlockedException extends RuntimeException {
    private String message = ERR_ACCOUNT_IS_BLOCKED;

    @Override
    public String getMessage() {
        return message;
    }

    public AccountIsBlockedException(long accountId) {
        message += ":" + accountId;
    }

    public AccountIsBlockedException() {}
}
