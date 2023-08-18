package com.webshop.mapper;

import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.service.OrderService;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderItemMapper {
    private OrderService orderService;
    private ProductService productService;

    public OrderItemEntity toEntity(OrderItemDto dto) {
        return new OrderItemEntity(
                productService.find(dto.getProductId()),
                dto.getPrice(),
                dto.getQuantity()
            );
    }

    public OrderItemDto toDto(OrderItemEntity entity) {
        return new OrderItemDto(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getProduct().getImage(),
                entity.getPrice(),
                entity.getQuantity()
        );
    }
}
