package com.webshop.model.constants;

/**
 * Constants class holding error messages for exceptions.
 */
public class ExceptionConst {
    private ExceptionConst() {}
    /**
     * Error message for order not found exception.
     */
    public static final String ORDER_NOT_FOUND = "order with id %s doesn't exist in database";
    /**
     * Error message for product not found exception.
     */
    public static final String PRODUCT_NOT_FOUND = "product with id %s doesn't exist in database";
}
