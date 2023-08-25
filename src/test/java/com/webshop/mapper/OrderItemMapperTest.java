package com.webshop.mapper;

import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.model.entity.ProductEntity;
import com.webshop.service.impl.OrderServiceImpl;
import com.webshop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderItemMapperTest {

    @Mock
    private OrderServiceImpl orderServiceImpl;

    @Mock
    private ProductServiceImpl productServiceImpl;

    private static OrderItemMapper underTest;

    @BeforeAll
    public static void setup() {
        MockitoAnnotations.openMocks(OrderItemMapperTest.class); // Initialize the mocks
    }

    @Test
    void testToEntity() {
        underTest = new OrderItemMapper(orderServiceImpl, productServiceImpl);
        // Create a sample OrderItemDto
        OrderItemDto dto = new OrderItemDto();
        dto.setProductId(123L);
        dto.setPrice(new BigDecimal("50.00"));
        dto.setQuantity(2);

        // Mock ProductService to return a ProductEntity
        when(productServiceImpl.find(dto.getProductId())).thenReturn(new ProductEntity());

        // Call the method
        OrderItemEntity entity = underTest.toEntity(dto);

        // Verify the mapping logic
        assertEquals(dto.getProductId(), entity.getProduct().getId());
        assertEquals(dto.getPrice(), entity.getPrice());
        assertEquals(dto.getQuantity(), entity.getQuantity());
    }

    @Test
    void testToDto() {
        // Create a mock OrderItemEntity
        OrderItemEntity entity = mock(OrderItemEntity.class);
        when(entity.getProduct()).thenReturn(new ProductEntity());
        when(entity.getPrice()).thenReturn(new BigDecimal("50.00"));
        when(entity.getQuantity()).thenReturn(2L);

        // Call the method
        OrderItemDto dto = underTest.toDto(entity);

        // Verify the mapping logic
        assertEquals(entity.getProduct().getId(), dto.getProductId());
        assertEquals(entity.getPrice(), dto.getPrice());
        assertEquals(entity.getQuantity(), dto.getQuantity());
    }/*
    private static OrderItemMapper underTest;
    @Autowired
    private static OrderService orderService;
    @Autowired
    private static ProductService productService;


    @BeforeAll
    public static void setup() {
        underTest = new OrderItemMapper(orderService, productService);
    }
    @Test
    void toEntity() {

    }*/

   /* @Test
    void toDto() {
        //given
        Long productId = 2L;
        String productName = "Nike Air Jordan IV Bred";
        String productImage = "image";
        LocalDateTime productCreatedAt = LocalDateTime.now();
        BigDecimal price = BigDecimal.valueOf(222L);
        long quantity = 24L;
        long orderId = 1L;
        long orderItemId = 122L;
        OrderItemEntity orderItem = new OrderItemEntity(
                new ProductEntity(
                        productId,
                        productName,
                        "description",
                        "Nike",
                        "shoes",
                        new ProductInventoryEntity(
                                BigDecimal.valueOf(199L),
                                99L
                        ),
                        productImage,
                        productCreatedAt
                ),
                price,
                quantity
        );
        List<OrderItemEntity> items = List.of(
                orderItem
        );
        String status = "CREATED";
        LocalDateTime createdAt = LocalDateTime.now();
        BigDecimal total = BigDecimal.valueOf(199L);
        OrderEntity entity = new OrderEntity(
                orderId,
                //items,
                List.of(new OrderItemEntity(

                        new ProductEntity(
                                productId,
                                productName,
                                "description",
                                "Nike",
                                "shoes",
                                new ProductInventoryEntity(
                                        BigDecimal.valueOf(199L),
                                        99L
                                ),
                                productImage,
                                productCreatedAt
                        ),
                        price,
                        quantity
                ),
                status,
                createdAt,
                total
        );
        //when
        OrderItemDto dto = underTest.toDto(orderItem);
        //then
        assertAll(
                () -> assertEquals(productId, dto.getProductId()),
                () -> assertEquals(productName, dto.getProductName()),
                () -> assertEquals(productImage, dto.getProductImage()),
                () -> assertEquals(price, dto.getPrice()),
                () -> assertEquals(quantity, dto.getQuantity())
        );
    }*/
}