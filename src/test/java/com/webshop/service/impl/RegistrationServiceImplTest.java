package com.webshop.service.impl;

import com.webshop.model.entity.UserEntity;
import com.webshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationServiceImplTest {

    @Mock
    private UserService userService;

    private RegistrationServiceImpl underTest;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        underTest = new RegistrationServiceImpl(userService);
    }

    @Test
    void shouldRegisterUser() {
        // given

        // when

        // then
    }
}