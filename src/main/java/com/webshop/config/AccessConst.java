package com.webshop.config;

class AccessConst {
    private AccessConst(){}

    protected static final String[] RESOURCES_PUBLIC = {
            "/**",
            "/h2/**"
    };

    /**
     * User resources, available for registered and confirmed users
     */
    protected static final String[] RESOURCES_USER = {
            "/**"
    };

    /**
     * Admin resources, available for admin
     */
    protected static final String[] RESOURCES_ADMIN = {
            "/**"
    };
}
