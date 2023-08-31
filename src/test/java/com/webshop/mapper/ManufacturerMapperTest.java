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
    public void setUp() {
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
    long id = 1L;
    String name = "ManufacturerName";
    String taxCode = "TaxCode";
    AddressEntity addressEntity = new AddressEntity("Street", "ZipCode", "City", "Country");
    ManufacturerEntity manufacturerEntity = new ManufacturerEntity(id, name, addressEntity, taxCode);

    // when
    ManufacturerDto dto = underTest.entityToDto(manufacturerEntity);
    // then
    assertAll(
            () -> assertEquals(dto.getId(), id),
            () -> assertEquals(dto.getName(), name),
            () -> assertEquals(dto.getTaxCode(), taxCode)
            );
    }

    @Test
    void dtoToEntity() {
        // given
        long id = 1L;
        String name = "ManufacturerName";
        String taxCode = "TaxCode";
        AddressDto addressDto = new AddressDto(1L, "Street", "ZipCode", "City", "Country");
        ManufacturerDto manufacturerDto = new ManufacturerDto(id, name, addressDto, taxCode);

        // when
        ManufacturerEntity entity = underTest.dtoToEntity(manufacturerDto);

        // then
        assertAll(
                () -> assertEquals(entity.getName(), name),
                () -> assertEquals(entity.getTaxCode(), taxCode)
        );
    }
}