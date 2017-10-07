package com.nazar.service.exception;

public class NotEnoughMoneyException extends RuntimeException {
    private String message = "Not enough money: ";

    @Override
    public String getMessage() {
        return message;
    }

    public NotEnoughMoneyException(long balance, long need) {
        message += (double)need/100 + " (" + (double)balance/100 + ");";
    }

    public NotEnoughMoneyException(Exception e) {
        super(e);
    }
}
