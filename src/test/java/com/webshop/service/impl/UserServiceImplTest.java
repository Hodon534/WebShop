package com.webshop.service.impl;

import com.webshop.exception.UserException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.UserEntity;
import com.webshop.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    private UserServiceImpl underTest;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        underTest = new UserServiceImpl(userRepository);
    }

    @Test
    void shouldLoadUserByUsername() {
        // given
        String username = "test@example.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(userEntity));

        // when
        UserEntity loadedUser = (UserEntity) underTest.loadUserByUsername(username);

        // then
        assertAll(
                () -> assertNotNull(loadedUser),
                () -> assertEquals(username, loadedUser.getUsername())
        );
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void shouldThrowUsernameNotFoundException() {
        // given
        String username = "nonexistent@example.com";

        // when
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // then
        UsernameNotFoundException exception = assertThrows(
                UsernameNotFoundException.class,
                () -> underTest.loadUserByUsername(username)
        );
        assertEquals(ExceptionConst.USER_NOT_FOUND_MESSAGE, exception.getMessage());
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void shouldFindExistingUser() {
        // given
        long userId = 1L;
        String username = "test@example.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setUsername(username);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));

        // when
        UserEntity foundUser = underTest.find(userId);

        // then
        assertAll(
                () -> assertNotNull(foundUser),
                () -> assertEquals(userId, foundUser.getId()),
                () -> assertEquals(username, foundUser.getUsername())
        );
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void shouldThrowUserExceptionWhenFindingNonexistentUser() {
        // given
        long userId = 1L;
        String errorMessage = "there is no user attached to the given email address";

        // when
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // then
        UserException exception = assertThrows(UserException.class, () -> underTest.find(userId));
        assertEquals(errorMessage, exception.getMessage());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void shouldSignUpNewUser() {
        // given
        String username = "test@example.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        // when
        UserEntity signedUpUser = underTest.singUp(userEntity);

        // then
        assertEquals(userEntity, signedUpUser);
        verify(userRepository, times(1)).findByUsername(username);
        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    void shouldThrowUserExceptionWhenSigningUpExistingUser() {
        // given
        String username = "test@example.com";
        String errorMessage = "there is already a user attached to the given email address";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(userEntity));

        // when
        UserException exception = assertThrows(UserException.class, () -> underTest.singUp(userEntity));

        // then
        assertEquals(errorMessage, exception.getMessage());
        verify(userRepository, times(1)).findByUsername(username);
        verify(userRepository, times(0)).save(userEntity);
    }
}