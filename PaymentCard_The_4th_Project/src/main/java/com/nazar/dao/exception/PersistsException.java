package com.nazar.dao.exception;

public class PersistsException extends Exception{
    public PersistsException() {
        super();
    }

    public PersistsException(String message) {
        super(message);
    }

    public PersistsException(Exception e) {
        super(e);
    }
}
