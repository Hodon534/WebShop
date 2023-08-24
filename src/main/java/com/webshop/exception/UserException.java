package com.webshop.exception;

import org.apache.catalina.User;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }
}
