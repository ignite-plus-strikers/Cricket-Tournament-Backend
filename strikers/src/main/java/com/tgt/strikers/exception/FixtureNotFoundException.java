package com.tgt.strikers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FixtureNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public FixtureNotFoundException(String message) {
        super(message);
    }
}

