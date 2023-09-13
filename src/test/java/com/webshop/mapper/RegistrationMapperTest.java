package com.webshop.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RegistrationMapperTest {
    //todo how to mock
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private AddressMapper addressMapper;
    private RegistrationMapper underTest;

    @BeforeEach
    void setUp() {
    addressMapper = mock(AddressMapper.class);
    underTest = new RegistrationMapper(bCryptPasswordEncoder, addressMapper);
    }

    @Test
    void registrationRequestToUserEntity() {
        // given

        // when

        // then
    }
}