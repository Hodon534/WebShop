package com.webshop.mapper;

import com.webshop.model.dto.CartDto;
import com.webshop.model.dto.CartItemDto;
import com.webshop.model.entity.OrderEntity;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class CartToOrderMapper {
    private ProductService productService;

    public OrderEntity cartToOrder(CartDto cart) {
        return new OrderEntity(
                cart.getItems().stream().map(this::cartItemToOrderItem).toList()
        );
    }

    public OrderItemEntity cartItemToOrderItem(CartItemDto cartItem) {
        return new OrderItemEntity(
                productService.find(cartItem.getId()),
                cartItem.getPrice(),
                cartItem.getQuantity()
        );
    }

}
