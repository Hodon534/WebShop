package com.webshop.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing a shopping cart.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartDto {
    private List<CartItemDto> items = new ArrayList<>();

}
