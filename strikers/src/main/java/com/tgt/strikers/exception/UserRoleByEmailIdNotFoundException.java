package com.tgt.strikers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserRoleByEmailIdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public UserRoleByEmailIdNotFoundException(String message) {
        super(message);
    }
}