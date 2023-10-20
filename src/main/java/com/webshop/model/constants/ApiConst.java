package com.webshop.model.constants;

public class ApiConst {
    private ApiConst() {
    }
    public static final String CORS_BASE_LINK = "http://localhost:4200";
    /**
     * Constant defining the maximum age for CORS (Cross-Origin Resource Sharing) configuration.
     */
    public static final long CORS_MAX_AGE = 3600L;
    public static final String SLASH_TEXT = "/";
    public static final String LOGIN_PAGE_TEXT = "login";
    public static final String LOGOUT_PAGE_TEXT = "logout";

    public static final String DOUBLE_ASTERISK_TEXT = "**";
    //public static final String API_TEXT = "api";
    //public static final String VERSION_TEXT = "v1";
    //public static final String ORDERS_TEXT = "orders";
}
