package com.webshop.mapper;

import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import com.webshop.service.ManufacturerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductMapperTest {

    @Mock
    private ManufacturerService manufacturerService;

    private ProductMapper underTest;

    @BeforeEach
    public void setUp() {
        long manufacturerId = 15L;
        String manufacturerName = "ManufacturerName";

        ManufacturerEntity manufacturer = new ManufacturerEntity(
                manufacturerName,
                new AddressEntity(
                        "street",
                        "zipCode",
                        "city",
                        "country"
                ),
                "taxCode"
        );
        manufacturer.setId(manufacturerId);

        manufacturerService = mock(ManufacturerService.class);
        when(manufacturerService.find(manufacturerId)).thenReturn(manufacturer);
        underTest = new ProductMapper(manufacturerService);
    }

    @Test
    void entityToDto() {
        // given
        long productId = 1L;
        String name = "productsName";
        String description = "productsDescription";
        String manufacturerName = "ManufacturerName";
        long manufacturerId = 15L;
        ManufacturerEntity manufacturer = new ManufacturerEntity(
                manufacturerName,
                new AddressEntity(
                        "street",
                        "zipCode",
                        "city",
                        "country"
                ),
                "taxCode"
        );
        manufacturer.setId(manufacturerId);
        String category = "consumer electronics";
        BigDecimal price = BigDecimal.valueOf(199L);
        long quantity = 100L;
        ProductInventoryEntity productInventory = new ProductInventoryEntity(
                price,
                quantity
        );
        productInventory.setId(5L);
        String image = "imageUrl";
        LocalDateTime createdAt = LocalDateTime.now();
        ProductEntity entity = new ProductEntity(
                name,
                description,
                manufacturer,
                category,
                productInventory,
                image
        );
        entity.setId(productId);
        // when
        ProductCardDto dto = underTest.entityToDto(entity);
        //then
        assertAll(
                () -> assertEquals(productId, dto.getId()),
                () -> assertEquals(name, dto.getName()),
                () -> assertEquals(description, dto.getDescription()),
                () -> assertEquals(manufacturerName, dto.getManufacturerName()),
                () -> assertEquals(manufacturerId, dto.getManufacturerId()),
                () -> assertEquals(category, dto.getCategory()),
                () -> assertEquals(image, dto.getImage()),
                () -> assertEquals(price, dto.getPrice()),
                () -> assertEquals(quantity, dto.getInStock())
        );
    }

    @Test
    void dtoToNewEntity() {
        // given
        long productId = 1L;
        String name = "productsName";
        String description = "productsDescription";
        String manufacturerName = "ManufacturerName";
        long manufacturerId = 15L;
        String category = "consumer electronics";
        BigDecimal price = BigDecimal.valueOf(199L);
        long quantity = 100L;
        String image = "imageUrl";
        ProductCardDto dto = new ProductCardDto(
                productId,
                name,
                description,
                manufacturerName,
                manufacturerId,
                category,
                image,
                price,
                quantity
        );
        // when
        ProductEntity entity = underTest.dtoToNewEntity(dto);
        // then
        assertAll(
                () -> assertEquals(name, entity.getName()),
                () -> assertEquals(description, entity.getDescription()),
                () -> assertEquals(category, entity.getCategory()),
                () -> assertEquals(image, entity.getImage()),
                () -> assertEquals(manufacturerId, entity.getManufacturer().getId()),
                () -> assertEquals(manufacturerName, entity.getManufacturer().getName()),
                () -> assertEquals(price, entity.getInventory().getCurrentPrice()),
                () -> assertEquals(quantity, entity.getInventory().getInStock())
        );


    }
}