package com.webshop.exception;

/**
 * Custom exception class for product-related errors.
 */
public class ProductException extends RuntimeException {

    /**
     * Constructs a ProductException with the specified error message.
     *
     * @param message The error message explaining the exception.
     */
    public ProductException(String message) {
        super(message);
    }
}
