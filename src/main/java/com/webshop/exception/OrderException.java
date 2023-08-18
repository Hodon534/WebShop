package com.webshop.exception;

/**
 * Custom exception class for order-related errors.
 */
public class OrderException extends RuntimeException {

    /**
     * Constructs an OrderException with the specified error message.
     *
     * @param message The error message explaining the exception.
     */
    public OrderException(String message) {
        super(message);
    }
}
