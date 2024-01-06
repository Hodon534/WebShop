package com.webshop.config;

/**
 * The AccessConst class defines constants for specifying access control to various resources in the web application.
 * It groups these resources into three categories: public, user, and admin resources, each with an array of URLs.
 * This class is used in Spring Security configuration to define access permissions based on user roles.
 */
class AccessConst {
    // Private constructor to prevent instantiation since this class contains only constants.
    private AccessConst(){}

    /**
     * Public resources, available for all
     */
    protected static final String[] RESOURCES_PUBLIC = {
            "/**",
            "/api/v1/products/**",
            "/home",
            "/login",
            "/api/v1/registration",
            "/api/v1/registration/**",
            "/api/v1/products/findAll",
            "/api/v1/products/find/id/**"
    };

    /**
     * User resources, available for registered users
     */
    protected static final String[] RESOURCES_USER = {
            "/h2/**",
            "/api/v1/cart",
            "/api/v1/cart/**",
            "/api/v1/manufacturers",
            "/api/v1/manufacturers/**",
            "/api/v1/products/add"
    };

    /**
     * Admin resources, available for admin
     */
    protected static final String[] RESOURCES_ADMIN = {
            "/**"
    };
}
