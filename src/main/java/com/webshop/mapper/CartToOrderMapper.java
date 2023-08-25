package com.webshop.mapper;

import com.webshop.model.dto.CartDto;
import com.webshop.model.dto.CartItemDto;
import com.webshop.model.entity.OrderEntity;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.service.ProductService;
import com.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting Cart-related DTOs to Order-related entities.
 */
@AllArgsConstructor
@Component
public class CartToOrderMapper {
    private final ProductService productService;
    private final UserService userService;


    /**
     * Converts a CartDto to an OrderEntity.
     *
     * @param cart The CartDto to be converted.
     * @return An OrderEntity representing the converted cart.
     */
    public OrderEntity cartToOrder(CartDto cart) {
        return new OrderEntity(
                cart.getItems().stream().map(this::cartItemToOrderItem).toList(),
                userService.find(cart.getUserId())
        );
    }

    /**
     * Converts a CartItemDto to an OrderItemEntity.
     *
     * @param cartItem The CartItemDto to be converted.
     * @return An OrderItemEntity representing the converted cart item.
     */
    public OrderItemEntity cartItemToOrderItem(CartItemDto cartItem) {
        return new OrderItemEntity(
                productService.find(cartItem.getId()),
                cartItem.getPrice(),
                cartItem.getQuantity()
        );
    }

}
