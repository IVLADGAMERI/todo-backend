package com.cmd.todo.exception;

public class IllegalDataMutationException extends RuntimeException {
    public IllegalDataMutationException(String message) {
        super(message);
    }
}
