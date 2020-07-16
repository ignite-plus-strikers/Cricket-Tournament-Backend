package com.tgt.strikers.Exception;

public class APIException extends RuntimeException {

    private static final long serialVersionUID= 1L;
    public APIException(String message) {
        super(message);
    }
}