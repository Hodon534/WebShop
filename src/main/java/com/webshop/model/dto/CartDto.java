package com.webshop.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartDto {
    private List<CartItemDto> items = new ArrayList<>();

}
