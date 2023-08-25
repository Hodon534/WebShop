package com.webshop.exception;

/**
 * Custom exception class for manufacturer-related errors.
 */
public class ManufacturerException extends RuntimeException {

    /**
     * Constructs a ManufacturerException with the specified error message.
     *
     * @param message The error message explaining the exception.
     */
    public ManufacturerException(String message) {
        super(message);
    }
}
