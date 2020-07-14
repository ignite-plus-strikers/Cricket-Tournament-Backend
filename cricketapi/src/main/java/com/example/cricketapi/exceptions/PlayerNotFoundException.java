package com.example.cricketapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {

    private static final long serialVersionId = 1L;
    public PlayerNotFoundException(String message) {
        super(message);
    }
}