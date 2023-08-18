package com.webshop.model.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) representing a cart item.
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemDto {
    private long id;
    private String name;
    private BigDecimal price;
    private long quantity;
    private String image;
}