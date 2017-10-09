package com.nazar.service.exception;

import static com.nazar.language.StringGlobalConstants.ERR_CARD_CREATING;

public class CardCreatingException extends RuntimeException{
    private String message = ERR_CARD_CREATING;

    @Override
    public String getMessage() {
        return message;
    }

    public CardCreatingException(Exception e) {
        super(e);
    }
}
