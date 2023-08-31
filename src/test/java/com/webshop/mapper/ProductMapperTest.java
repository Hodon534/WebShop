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
                manufacturerId,
                manufacturerName,
                new AddressEntity(
                        "street",
                        "zipCode",
                        "city",
                        "country"
                ),
                "taxCode"
        );

        manufacturerService = mock(ManufacturerService.class);
        when(manufacturerService.find(manufacturerId)).thenReturn(manufacturer);
        underTest = new ProductMapper(manufacturerService);
    }

    @Test
    void entityToDto() {
        // given
        long id = 1L;
        String name = "productsName";
        String description = "productsDescription";
        String manufacturerName = "ManufacturerName";
        long manufacturerId = 15L;
        ManufacturerEntity manufacturer = new ManufacturerEntity(
                manufacturerId,
                manufacturerName,
                new AddressEntity(
                        "street",
                        "zipCode",
                        "city",
                        "country"
                ),
                "taxCode"
        );
        String category = "consumer electronics";
        BigDecimal price = BigDecimal.valueOf(199L);
        long quantity = 100L;
        ProductInventoryEntity productInventory = new ProductInventoryEntity(
                5L,
                price,
                quantity
        );
        String image = "imageUrl";
        LocalDateTime createdAt = LocalDateTime.now();
        ProductEntity entity = new ProductEntity(
                id,
                name,
                description,
                manufacturer,
                category,
                productInventory,
                image,
                createdAt
        );
        // when
        ProductCardDto dto = underTest.entityToDto(entity);
        //then
        assertAll(
                () -> assertEquals(dto.getId(), id),
                () -> assertEquals(dto.getName(), name),
                () -> assertEquals(dto.getDescription(), description),
                () -> assertEquals(dto.getManufacturerName(), manufacturerName),
                () -> assertEquals(dto.getManufacturerId(), manufacturerId),
                () -> assertEquals(dto.getCategory(), category),
                () -> assertEquals(dto.getImage(), image),
                () -> assertEquals(dto.getPrice(), price),
                () -> assertEquals(dto.getInStock(), quantity)
        );
    }

    @Test
    void dtoToNewEntity() {
        // given
        long id = 1L;
        String name = "productsName";
        String description = "productsDescription";
        String manufacturerName = "ManufacturerName";
        long manufacturerId = 15L;
        String category = "consumer electronics";
        BigDecimal price = BigDecimal.valueOf(199L);
        long quantity = 100L;
        String image = "imageUrl";
        ProductCardDto dto = new ProductCardDto(
                id,
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
                () -> assertEquals(entity.getName(), name),
                () -> assertEquals(entity.getDescription(), description),
                () -> assertEquals(entity.getCategory(), category),
                () -> assertEquals(entity.getImage(), image),
                () -> assertEquals(entity.getManufacturer().getId(), manufacturerId),
                () -> assertEquals(entity.getManufacturer().getName(), manufacturerName),
                () -> assertEquals(entity.getInventory().getCurrentPrice(), price),
                () -> assertEquals(entity.getInventory().getInStock(), quantity)
        );


    }
}