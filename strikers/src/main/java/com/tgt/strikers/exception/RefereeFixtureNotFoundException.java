package com.tgt.strikers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RefereeFixtureNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public RefereeFixtureNotFoundException(String message) {
        super(message);
    }
}