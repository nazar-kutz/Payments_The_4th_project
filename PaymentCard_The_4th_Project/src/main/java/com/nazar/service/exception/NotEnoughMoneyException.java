package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_NOT_ENOUGH_MONEY;

public class NotEnoughMoneyException extends RuntimeException {
    private String message = ERR_NOT_ENOUGH_MONEY;

    @Override
    public String getMessage() {
        return message;
    }

    public NotEnoughMoneyException(long balance, long need) {
        StringBuilder sb = new StringBuilder(message).append(":").append((double)need/100).
                append(" (").append((double)balance/100).append(");");
        message = sb.toString();
    }

    public NotEnoughMoneyException(Exception e) {
        super(e);
    }
}
