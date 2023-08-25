package com.webshop.exception;

/**
 * Custom exception class for user-related errors.
 */
public class UserException extends RuntimeException {

    /**
     * Constructs a UserException with the specified error message.
     *
     * @param message The error message explaining the exception.
     */
    public UserException(String message) {
        super(message);
    }
}
