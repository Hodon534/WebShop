package com.webshop.service.impl;

import com.webshop.exception.ManufacturerException;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.repository.ManufacturerRepository;
import com.webshop.service.ManufacturerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManufacturerServiceImplTest {

    @Mock
    private ManufacturerRepository manufacturerRepository;

    private ManufacturerServiceImpl underTest;

    @BeforeEach
    void setUp() {
        manufacturerRepository = mock(ManufacturerRepository.class);
        underTest = new ManufacturerServiceImpl(manufacturerRepository);
    }

    @Test
    void shouldFindExistingEntity() {
        // given
        long manufacturerId = 14L;
        String name = "ManufacturerName";
        String taxCode = "TaxCode";
        AddressEntity addressEntity = new AddressEntity(
                "Street",
                "ZipCode",
                "City",
                "Country");
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity(
                name,
                addressEntity,
                taxCode);
        manufacturerEntity.setId(manufacturerId);
        when(manufacturerRepository.findById(manufacturerId)).thenReturn(Optional.of(manufacturerEntity));
        // when
        ManufacturerEntity manufacturerFound = underTest.find(manufacturerId);
        // then
        assertAll(
                () -> assertNotNull(manufacturerFound),
                () -> assertEquals(manufacturerId, manufacturerFound.getId()),
                () -> assertEquals(name, manufacturerFound.getName()),
                () -> assertEquals(taxCode, manufacturerFound.getTaxCode())
        );
        verify(manufacturerRepository, times(1)).findById(manufacturerId);

    }

    @Test
    void shouldReturnManufacturerException() {
        // given
        long manufacturerId = 23L;
        String errorMessage = String.format("manufacturer with id %s doesn't exist in database", manufacturerId);
        // when
        when(manufacturerRepository.findById(manufacturerId)).thenReturn(Optional.empty());
        verify(manufacturerRepository, times(0)).findById(manufacturerId);

        //then

        ManufacturerException exception = assertThrows(ManufacturerException.class,
                () -> underTest.find(manufacturerId));
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void findAll() {
        // given
        long firstManufacturerId = 14L;
        String firstName = "FirstManufacturerName";
        String firstTaxCode = "FirstTaxCode";
        AddressEntity addressEntity = new AddressEntity(
                "Street",
                "ZipCode",
                "City",
                "Country");
        ManufacturerEntity firstManufacturerEntity = new ManufacturerEntity(
                firstName,
                addressEntity,
                firstTaxCode);
        firstManufacturerEntity.setId(firstManufacturerId);
        long secondManufacturerId = 14L;
        String secondName = "FirstManufacturerName";
        String secondTaxCode = "FirstTaxCode";
        ManufacturerEntity secondManufacturerEntity = new ManufacturerEntity(
                secondName,
                addressEntity,
                secondTaxCode);
        secondManufacturerEntity.setId(secondManufacturerId);
        List<ManufacturerEntity> expectedManufacturers = List.of(firstManufacturerEntity, secondManufacturerEntity);
        when(manufacturerRepository.findAll()).thenReturn(expectedManufacturers);
        // when
        List<ManufacturerEntity> returnedManufacturers = underTest.findAll();
        // then
        assertAll(
                () -> assertNotNull(returnedManufacturers),
                () -> assertEquals(expectedManufacturers.size(), returnedManufacturers.size()),
                () -> assertEquals(expectedManufacturers, returnedManufacturers)
        );
    }

    @Test
    void save() {
        // given
        long manufacturerId = 14L;
        String name = "ManufacturerName";
        String taxCode = "TaxCode";
        AddressEntity addressEntity = new AddressEntity(
                "Street",
                "ZipCode",
                "City",
                "Country");
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity(
                name,
                addressEntity,
                taxCode);
        manufacturerEntity.setId(manufacturerId);
        when(manufacturerRepository.save(manufacturerEntity)).thenReturn(manufacturerEntity);

        // when
        ManufacturerEntity returnedManufacturer = underTest.save(manufacturerEntity);

        // then
        assertEquals(manufacturerEntity, returnedManufacturer);
    }
}