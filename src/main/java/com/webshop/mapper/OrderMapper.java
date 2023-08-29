package com.webshop.mapper;

import com.webshop.model.dto.OrderDto;
import com.webshop.model.entity.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Mapper class responsible for converting between OrderEntity and OrderDto objects.
 */
@AllArgsConstructor
@Component
public class OrderMapper {
    private OrderItemMapper orderItemMapper;
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";


    /**
     * Converts an OrderEntity object to an OrderDto object.
     *
     * @param entity The OrderEntity to be converted.
     * @return An OrderDto representing the converted entity.
     */
    public OrderDto toDto(OrderEntity entity) {
        return new OrderDto(
                entity.getId(),
                entity.getOrderItems().stream().map(item -> orderItemMapper.toDto(item)).toList(),
                entity.getStatus(),
                dateFormat(entity.getCreatedAt()),
                entity.getTotal(),
                entity.getUser().getId()
        );
    }

    private String dateFormat(LocalDateTime createdAt) {
        return createdAt.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
}
