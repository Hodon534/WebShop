package com.webshop.mapper;

import com.webshop.model.dto.OrderDto;
import com.webshop.model.entity.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderMapper {
    private OrderItemMapper orderItemMapper;

    public OrderEntity dtoToNewEntity(OrderDto dto) {
        return new OrderEntity(
                dto.getOrderItems().stream().map(item -> orderItemMapper.toEntity(item)).toList()
        );
    }

    public OrderDto toDto(OrderEntity entity) {
        return new OrderDto(
                entity.getId(),
                entity.getOrderItems().stream().map(item -> orderItemMapper.toDto(item)).toList(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getTotal()
        );
    }
}
