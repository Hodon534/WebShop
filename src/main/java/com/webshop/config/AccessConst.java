package com.webshop.config;

class AccessConst {
    private AccessConst(){}

    /**
     * Public resources, available for all users
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
     * User resources, available for registered and confirmed users
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
