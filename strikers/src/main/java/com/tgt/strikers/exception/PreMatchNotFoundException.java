package com.tgt.strikers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PreMatchNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PreMatchNotFoundException(String message) {
        super(message);
    }
}
