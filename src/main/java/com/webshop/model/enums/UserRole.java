package com.webshop.model.enums;

import lombok.Getter;

/**
 * Enum representing user roles in the application.
 */
@Getter
public enum UserRole {
    /**
     * Represents a standard user role.
     */
    USER,

    /**
     * Represents an admin user role with elevated privileges.
     */
    ADMIN;
}
