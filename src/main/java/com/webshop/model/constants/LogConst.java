package com.webshop.model.constants;

/**
 * Constants class holding log messages.
 */
public class LogConst {
    private LogConst(){}

    /**
     * Log message for adding a new product.
     */
    public static final String PRODUCT_ADDED_MESSAGE = "New Product has been added";

    /**
     * Log message for adding a new order.
     */
    public static final String ORDER_ADDED_MESSAGE = "New Order has been added";

    /**
     * Log message for updating the database with uploaded products.
     */
    public static final String DATABASE_PRODUCTS_UPDATED_MESSAGE = "Database has been updated, products had been uploaded";

    /**
     * Log message for updating the database with uploaded manufacturers.
     */
    public static final String DATABASE_MANUFACTURERS_UPDATED_MESSAGE = "Database has been updated, manufacturers had been uploaded";

    /**
     * Log message for updating the database with uploaded users.
     */
    public static final String DATABASE_USERS_UPDATED_MESSAGE = "Database has been updated, users had been uploaded";

    /**
     * Log message for updating the database with uploaded carts and converted to orders.
     */
    public static final String DATABASE_CARTS_UPDATED_MESSAGE = "Database has been updated, carts had been uploaded";

    /**
     * Log message for adding a new manufacturer.
     */
    public static final String MANUFACTURER_ADDED_MESSAGE = "New Manufacturer has been added";

    /**
     * Log message for registering a new user.
     */
    public static final String USER_NEW_REGISTERED_MESSAGE = "New User has been registered";
}
