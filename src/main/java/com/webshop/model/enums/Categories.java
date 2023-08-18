package com.webshop.model.enums;

import lombok.Getter;

@Getter
public enum Categories {
    MENS_CLOTHING("men's clothing"),
    WOMENS_CLOTHING("women's clothing"),
    JEWELERY("jewelery"),
    ELECTRONICS("electronics");

    Categories(String name) {
    }
}
