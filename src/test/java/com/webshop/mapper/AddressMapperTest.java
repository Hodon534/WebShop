package com.webshop.mapper;

import com.webshop.model.dto.AddressDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AddressMapperTest {

    @Autowired
    private AddressMapper underTest;

    @BeforeEach
    void start() {
        underTest = new AddressMapper();
    }
    @Test
    void entityToDto() {
        // given
        long id = 12L;
        String street = "17 Avenue";
        String zipCode = "41550";
        String city = "New York";
        String country = "USA";
        AddressEntity entity = new AddressEntity(
                id,
                street,
                zipCode,
                city,
                country
        );
        // when
        AddressDto dto = underTest.entityToDto(entity);
        // then
        assertAll(
                () -> assertEquals(dto.getId(), id),
                () -> assertEquals(dto.getStreet(), street),
                () -> assertEquals(dto.getZipCode(), zipCode),
                () -> assertEquals(dto.getCity(), city),
                () -> assertEquals(dto.getCountry(), country)
        );
    }

    @Test
    void dtoToEntity() {
        // given
        long id = 12L;
        String street = "17 Avenue";
        String zipCode = "41550";
        String city = "New York";
        String country = "USA";
        AddressDto dto = new AddressDto(
                id,
                street,
                zipCode,
                city,
                country
        );
        // when
        AddressEntity entity = underTest.dtoToEntity(dto);
        // then
        assertAll(
                () -> assertEquals(entity.getStreet(), street),
                () -> assertEquals(entity.getZipCode(), zipCode),
                () -> assertEquals(entity.getCity(), city),
                () -> assertEquals(entity.getCountry(), country)
        );
    }
}