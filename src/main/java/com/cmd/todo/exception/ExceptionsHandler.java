package com.cmd.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(PrincipalIsNullException.class)
    public ResponseEntity<String> handleUnauthorized(PrincipalIsNullException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({NoSuchElementException.class, DateTimeParseException.class})
    public ResponseEntity<String> handleBadRequest(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalDataMutationException.class)
    public ResponseEntity<String> handleForbidden(IllegalDataMutationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }
}
