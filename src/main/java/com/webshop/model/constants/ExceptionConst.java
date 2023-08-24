package com.webshop.model.constants;

/**
 * Constants class holding error messages for exceptions.
 */
public class ExceptionConst {
    private ExceptionConst() {}
    /**
     * Error message for order not found exception.
     */
    public static final String ORDER_NOT_FOUND_MESSAGE = "order with id %s doesn't exist in database";
    /**
     * Error message for product not found exception.
     */
    public static final String PRODUCT_NOT_FOUND_MESSAGE = "product with id %s doesn't exist in database";

    public static final String MANUFACTURER_NOT_FOUND_MESSAGE = "manufacturer with id %s doesn't exist in database";
    public static final String USER_NOT_FOUND_MESSAGE = "there is no user attached to the given email address";
    public static final String USER_ALREADY_REGISTERED_MESSAGE = "there is already a user attached to the given email address";
}
