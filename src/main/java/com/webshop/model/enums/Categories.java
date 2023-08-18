package com.webshop.model.enums;

import lombok.Getter;

/**
 * Enum representing different categories of products.
 */
@Getter
public enum Categories {
    MENS_CLOTHING("men's clothing"),
    WOMENS_CLOTHING("women's clothing"),
    JEWELERY("jewelery"),
    ELECTRONICS("electronics");

    private final String name;
    Categories(String name) {
        this.name = name;
    }
}
