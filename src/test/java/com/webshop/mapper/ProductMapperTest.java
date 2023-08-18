package com.webshop.mapper;

import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {
    @Autowired
    private ProductMapper underTest;

    @BeforeEach
    void setUnderTest() {
        underTest = new ProductMapper();
    }

    @Test
    void entityToDto() {
        //given
        Long productId = 1L;
        String name = "Nike Air Jordan IV Bred";
        String description = "new shoes by Nike";
        String manufacturer = "nike";
        String category = "men's clothing";
        String image = "https://via.placeholder.com/400";
        BigDecimal price = BigDecimal.valueOf(199L);
        long inStock = 100L;
        LocalDateTime dateTime = LocalDateTime.now();

        ProductEntity entity = new ProductEntity(
                productId,
                name,
                description,
                manufacturer,
                category,
                new ProductInventoryEntity(
                        price,
                        inStock
                ),
                image,
                dateTime
        );
        //when
        ProductCardDto dto = underTest.entityToDto(entity);
        //then
        assertAll(
                () -> assertEquals(productId, dto.getId()),
                () -> assertEquals(name, dto.getName()),
                () -> assertEquals(description, dto.getDescription()),
                () -> assertEquals(manufacturer, dto.getManufacturer()),
                () -> assertEquals(category, dto.getCategory()),
                () -> assertEquals(price, dto.getPrice()),
                () -> assertEquals(inStock, dto.getInStock()),
                () -> assertEquals(image, dto.getImage())
        );
    }

    @Test
    void dtoToNewEntity() {
        //given
        String name = "Nike Air Jordan IV Bred";
        String description = "new shoes by Nike";
        String manufacturer = "nike";
        String category = "men's clothing";
        String image = "https://via.placeholder.com/400";
        BigDecimal price = BigDecimal.valueOf(199L);
        long inStock = 100L;

        ProductCardDto dto = new ProductCardDto(
                name,
                description,
                manufacturer,
                category,
                image,
                price,
                inStock
        );
        //when
        ProductEntity entity = underTest.dtoToNewEntity(dto);
        //then
        assertAll(
                () -> assertEquals(name, entity.getName()),
                () -> assertEquals(description, entity.getDescription()),
                () -> assertEquals(manufacturer, entity.getManufacturer()),
                () -> assertEquals(category, entity.getCategory()),
                () -> assertEquals(image, entity.getImage()),
                () -> assertEquals(price, entity.getInventory().getCurrentPrice()),
                () -> assertEquals(inStock, entity.getInventory().getInStock())
        );
    }
}