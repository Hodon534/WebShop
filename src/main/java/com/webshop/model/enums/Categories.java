package com.webshop.model.enums;

import lombok.Getter;

//todo Remove class? it's already in front end

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
