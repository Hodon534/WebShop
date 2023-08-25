package com.webshop.service;

import com.webshop.repository.ProductRepository;
import com.webshop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    private ProductServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductServiceImpl(productRepository);
    }
    @Test
    void save() {
    }

    @Test
    void findAll() {
    }
}