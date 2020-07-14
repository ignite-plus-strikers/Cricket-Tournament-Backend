package com.example.cricketapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle specific exception
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException
    (PlayerNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> handleAPIException
            (PlayerNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    //Handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException
    (PlayerNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Handle custom validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error", exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
