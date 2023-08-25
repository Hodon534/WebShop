package com.webshop.mapper;

import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting between OrderItemEntity and OrderItemDto objects.
 */
@AllArgsConstructor
@Component
public class OrderItemMapper {
    private ProductService productService;

    /**
     * Converts an OrderItemDto object to an OrderItemEntity object.
     *
     * @param dto The OrderItemDto to be converted.
     * @return An OrderItemEntity representing the converted dto.
     */
    public OrderItemEntity toEntity(OrderItemDto dto) {
        return new OrderItemEntity(
                productService.find(dto.getProductId()),
                dto.getPrice(),
                dto.getQuantity()
            );
    }

    /**
     * Converts an OrderItemEntity object to an OrderItemDto object.
     *
     * @param entity The OrderItemEntity to be converted.
     * @return An OrderItemDto representing the converted entity.
     */
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
