package com.webshop.service.impl;

import com.webshop.exception.OrderException;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.OrderEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.Status;
import com.webshop.model.enums.UserRole;
import com.webshop.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl underTest;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        underTest = new OrderServiceImpl(orderRepository);
    }

    @Test
    void shouldFindExistingOrder() {
        // given
        Long orderId = 1L;
        LocalDateTime createdAt = LocalDateTime.now();
        BigDecimal total = BigDecimal.valueOf(100);
        String status = Status.CREATED.name();

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
        OrderEntity orderEntity = new OrderEntity(
                orderId,
                new ArrayList<>(),
                status,
                createdAt,
                total,
                user
        );

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));

        // when
        OrderEntity foundOrder = underTest.find(orderId);

        // then
        assertAll(
                () -> assertNotNull(foundOrder),
                () -> assertEquals(orderId, foundOrder.getId()),
                () -> assertEquals(createdAt, foundOrder.getCreatedAt()),
                () -> assertEquals(status, foundOrder.getStatus()),
                () -> assertEquals(total, foundOrder.getTotal()),
                () -> assertTrue(foundOrder.getOrderItems().isEmpty())
        );
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void shouldReturnOrderException() {
        // given
        Long orderId = 1L;
        String errorMessage = String.format("order with id %s doesn't exist in database", orderId);

        // when
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        // then
        OrderException exception = assertThrows(OrderException.class, () -> underTest.find(orderId));
        assertEquals(errorMessage, exception.getMessage());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void findAll() {
        // given
        List<OrderEntity> expectedOrders = new ArrayList<>();
        expectedOrders.add(new OrderEntity());
        expectedOrders.add(new OrderEntity());

        when(orderRepository.findAll()).thenReturn(expectedOrders);

        // when
        List<OrderEntity> returnedOrders = underTest.findAll();

        // then
        assertAll(
                () -> assertNotNull(returnedOrders),
                () -> assertEquals(expectedOrders.size(), returnedOrders.size()),
                () -> assertEquals(expectedOrders, returnedOrders)
        );
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void save() {
        // given
        OrderEntity orderEntity = new OrderEntity();

        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        // when
        OrderEntity savedOrder = underTest.save(orderEntity);

        // then
        assertEquals(orderEntity, savedOrder);
    }
}