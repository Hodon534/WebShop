package com.webshop.service.impl;

import com.webshop.exception.ProductException;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import com.webshop.repository.ProductRepository;
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

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductServiceImpl underTest;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        underTest = new ProductServiceImpl(productRepository);
    }

    @Test
    void shouldFindExistingProduct() {
        // given
        long productId = 1L;
        String name = "Product Name";
        String description = "Product Description";
        String category = "Category";
        String image = "Image URL";
        BigDecimal price = BigDecimal.valueOf(100);
        long quantity = 10;
        LocalDateTime createdAt = LocalDateTime.now();

        ProductInventoryEntity inventoryEntity = new ProductInventoryEntity(price, quantity);
        ProductEntity productEntity = new ProductEntity(name, description, null, category, inventoryEntity, image);
        productEntity.setId(productId);
        productEntity.setCreatedAt(createdAt);

        when(productRepository.findById(productId)).thenReturn(Optional.of(productEntity));

        // when
        ProductEntity foundProduct = underTest.find(productId);

        // then
        assertAll(
                () -> assertNotNull(foundProduct),
                () -> assertEquals(productId, foundProduct.getId()),
                () -> assertEquals(name, foundProduct.getName()),
                () -> assertEquals(description, foundProduct.getDescription()),
                () -> assertEquals(category, foundProduct.getCategory()),
                () -> assertEquals(image, foundProduct.getImage()),
                () -> assertEquals(price, foundProduct.getInventory().getCurrentPrice()),
                () -> assertEquals(quantity, foundProduct.getInventory().getInStock()),
                () -> assertEquals(createdAt, foundProduct.getCreatedAt())
        );
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void shouldReturnProductException() {
        // given
        long productId = 1L;
        String errorMessage = String.format("product with id %s doesn't exist in database", productId);

        // when
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // then
        ProductException exception = assertThrows(ProductException.class, () -> underTest.find(productId));
        assertEquals(errorMessage, exception.getMessage());
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void findAll() {
        // given
        List<ProductEntity> expectedProducts = new ArrayList<>();
        expectedProducts.add(new ProductEntity());
        expectedProducts.add(new ProductEntity());

        when(productRepository.findAll()).thenReturn(expectedProducts);

        // when
        List<ProductEntity> returnedProducts = underTest.findAll();

        // then
        assertAll(
                () -> assertNotNull(returnedProducts),
                () -> assertEquals(expectedProducts.size(), returnedProducts.size()),
                () -> assertEquals(expectedProducts, returnedProducts)
        );
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void save() {
        // given
        ProductEntity productEntity = new ProductEntity();

        when(productRepository.save(productEntity)).thenReturn(productEntity);

        // when
        ProductEntity savedProduct = underTest.save(productEntity);

        // then
        assertEquals(productEntity, savedProduct);
    }
}