package com.example.cricketapi.exceptions;

public class APIException extends RuntimeException {

    private static final long serialVersionId = 1L;
    public APIException(String message) {
        super(message);
    }
}