package com.webshop.mapper;

import com.webshop.model.dto.OrderItemDto;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.model.entity.OrderItemEntity;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import com.webshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderItemMapperTest {

    @Mock
    private ProductService productService;

    private OrderItemMapper underTest;
    private static final long productId = 5L;
    private static final String productName = "Product Name";
    private static final String productImage = "Product Image";


    @BeforeEach
    void setUp() {
        ProductInventoryEntity productInventory = new ProductInventoryEntity(
                BigDecimal.valueOf(299L),
                200L
        );
        productInventory.setId(2L);
        ProductEntity product = new ProductEntity(
                productName,
                "Products Description",
                new ManufacturerEntity(),
                "Products Category",
                productInventory,
                productImage
        );
        product.setId(productId);
        productService = mock(ProductService.class);
        when(productService.find(productId)).thenReturn(product);
        underTest = new OrderItemMapper(productService);
    }

    @Test
    void toEntity() {
        // given
        long itemId = 15L;
        BigDecimal productPrice = BigDecimal.valueOf(199L);
        long productQuantity = 2L;
        OrderItemDto dto = new OrderItemDto(
                itemId,
                productId,
                productName,
                productImage,
                productPrice,
                productQuantity
        );
        // when
        OrderItemEntity entity = underTest.toEntity(dto);

        // then

        assertAll(
                () -> assertEquals(productId, entity.getProduct().getId()),
                () -> assertEquals(productName, entity.getProduct().getName()),
                () -> assertEquals(productImage, entity.getProduct().getImage()),
                () -> assertEquals(productPrice, entity.getPrice()),
                () -> assertEquals(productQuantity, entity.getQuantity())
        );
    }

    @Test
    void toDto() {
        // given
        long itemId = 4L;
        BigDecimal productPrice = BigDecimal.valueOf(499L);
        long productQuantity = 12L;
        LocalDateTime createdAt = LocalDateTime.now();
        ProductInventoryEntity productInventory = new ProductInventoryEntity(
                BigDecimal.valueOf(299L),
                200L
        );
        productInventory.setId(2L);
        ProductEntity productEntity = new ProductEntity(
                productName,
                "Products Description",
                new ManufacturerEntity(),
                "Products Category",
                productInventory,
                productImage
        );
        productEntity.setId(productId);
        OrderItemEntity entity = new OrderItemEntity(
                productEntity,
                productPrice,
                productQuantity
        );
        entity.setId(itemId);

        // when
        OrderItemDto dto = underTest.toDto(entity);
        // then

        assertAll(
                () -> assertEquals(itemId, dto.getId()),
                () -> assertEquals(productId, dto.getProductId()),
                () -> assertEquals(productName, dto.getProductName()),
                () -> assertEquals(productImage, dto.getProductImage()),
                () -> assertEquals(productPrice, dto.getPrice()),
                () -> assertEquals(productQuantity, dto.getQuantity())
        );
    }
}