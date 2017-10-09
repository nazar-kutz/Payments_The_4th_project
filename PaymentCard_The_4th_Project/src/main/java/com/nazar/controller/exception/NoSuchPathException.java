package com.nazar.controller.exception;

import static com.nazar.language.StringGlobalConstants.ERR_NO_SUCH_PATH;

public class NoSuchPathException extends RuntimeException {
    private String message = ERR_NO_SUCH_PATH;

    @Override
    public String getMessage() {
        return message;
    }

    public NoSuchPathException(String message) {
        this.message += ":" + message;
    }
}
