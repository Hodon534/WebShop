package com.webshop.mapper;


import com.webshop.model.dto.OrderDto;
import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.OrderEntity;
import com.webshop.model.entity.OrderItemEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderMapperTest {

    @Autowired
    private static OrderItemMapper orderItemMapper;

    private static OrderMapper underTest;

    @BeforeAll
    public static void setup() {
        underTest = new OrderMapper(orderItemMapper);
    }

    @Test
    void toDto() {
        //given
        long id = 1L;
        List<OrderItemEntity> items = Collections.emptyList();
        String status = "CREATED";
        LocalDateTime createdAt = LocalDateTime.now();
        BigDecimal total = BigDecimal.valueOf(199L);
        OrderEntity entity = new OrderEntity(
                id,
                items,
                status,
                createdAt,
                total
        );
        //when
        OrderDto dto = underTest.toDto(entity);
        //then
        assertAll(
                () -> assertEquals(id, dto.getId()),
                () -> assertEquals(status, dto.getStatus()),
                () -> assertTrue(dto.getOrderItems().isEmpty()),
                () -> assertEquals(createdAt, dto.getCreatedAt()),
                () -> assertEquals(total, dto.getTotal())
        );
    }

    @Test
    void toEntityItemListShouldBeEmpty() {
        //given
        List<OrderItemDto> items = Collections.emptyList();
        OrderDto dto = new OrderDto(
                items
        );
        //when
        OrderEntity entity = underTest.dtoToNewEntity(dto);
        //then
        assertTrue(entity.getOrderItems().isEmpty());
    }
}