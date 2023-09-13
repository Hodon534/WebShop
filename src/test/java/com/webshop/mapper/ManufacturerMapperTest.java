package com.webshop.mapper;

import com.webshop.model.dto.AddressDto;
import com.webshop.model.dto.ManufacturerDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.ManufacturerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ManufacturerMapperTest {

    @Mock
    private AddressMapper addressMapper;

    private ManufacturerMapper underTest;

    @BeforeEach
    void setUp() {
        AddressEntity addressEntity = new AddressEntity(
                "Street",
                "ZipCode",
                "City",
                "Country");
        AddressDto addressDto = new AddressDto(
                1L,
                "Street",
                "ZipCode",
                "City",
                "Country");
        addressMapper = mock(AddressMapper.class);
        when(addressMapper.entityToDto(addressEntity)).thenReturn(addressDto);
        underTest = new ManufacturerMapper(addressMapper);
    }
    @Test
    void entityToDto() {
    // given
    long manufacturerId = 1L;
    String manufacturerName = "ManufacturerName";
    String taxCode = "TaxCode";
    AddressEntity addressEntity = new AddressEntity("Street", "ZipCode", "City", "Country");
    ManufacturerEntity manufacturerEntity = new ManufacturerEntity(
            manufacturerName, addressEntity, taxCode);
    manufacturerEntity.setId(manufacturerId);

    // when
    ManufacturerDto dto = underTest.entityToDto(manufacturerEntity);
    // then
    assertAll(
            () -> assertEquals(manufacturerId, dto.getId()),
            () -> assertEquals(manufacturerName, dto.getName()),
            () -> assertEquals(taxCode, dto.getTaxCode())
            );
    }

    @Test
    void dtoToEntity() {
        // given
        long manufacturerId = 1L;
        String manufacturerName = "ManufacturerName";
        String taxCode = "TaxCode";
        AddressDto addressDto = new AddressDto(1L, "Street", "ZipCode", "City", "Country");
        ManufacturerDto manufacturerDto = new ManufacturerDto(manufacturerId, manufacturerName, addressDto, taxCode);

        // when
        ManufacturerEntity entity = underTest.dtoToEntity(manufacturerDto);

        // then
        assertAll(
                () -> assertEquals(manufacturerName, entity.getName()),
                () -> assertEquals(taxCode, entity.getTaxCode())
        );
    }
}