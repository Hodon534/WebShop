package com.webshop.mapper;

import com.webshop.model.dto.OrderDto;
import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.OrderEntity;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.Status;
import com.webshop.model.enums.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderMapperTest {
    @Mock
    private OrderItemMapper orderItemMapper;

    private OrderMapper underTest;

    @BeforeEach
    void setUp() {
        orderItemMapper = mock(OrderItemMapper.class);
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        OrderItemDto orderItemDto = new OrderItemDto();
        when(orderItemMapper.toDto(orderItemEntity)).thenReturn(orderItemDto);
        underTest = new OrderMapper(orderItemMapper);
    }

    //todo
    @Test
    void toDto() {
        // given
        long orderId = 24L;
        String status = Status.CREATED.name();
        LocalDateTime createdAt = LocalDateTime.of(2023, 9, 11, 19, 33, 48, 64000);
        String createdAtString = "2023-09-11 19:33";
        BigDecimal total = BigDecimal.valueOf(199L);
        long userId = 12L;
        UserEntity user = new UserEntity(
                userId,
                "Username",
                "Password",
                UserRole.USER,
                false,
                true,
                "First Name",
                "Last Name",
                new AddressEntity(
                        "Street",
                        "ZipCode",
                        "City",
                        "Country"
                ),
                8423942354254L,
                new ArrayList<>()
        );
        OrderEntity entity = new OrderEntity(
                orderId,
                new ArrayList<>(),
                status,
                createdAt,
                total,
                user
        );
        // when
        OrderDto dto = underTest.toDto(entity);
        // then
        assertAll(
                () -> assertEquals(orderId, dto.getId()),
                () -> assertTrue(dto.getOrderItems().isEmpty()),
                () -> assertEquals(status, dto.getStatus()),
                () -> assertEquals(createdAtString, dto.getCreatedAt()),
                () -> assertEquals(total, dto.getTotal()),
                () -> assertEquals(userId, dto.getUserId())
        );
    }
}