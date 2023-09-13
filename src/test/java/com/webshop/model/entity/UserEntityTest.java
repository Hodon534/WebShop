package com.webshop.model.entity;

import com.webshop.model.enums.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    private UserEntity userEntity;
    private static final String username = "testuser@example.com";
    private static final String password = "password";
    private static final UserRole userRole = UserRole.USER;
    private static final String firstName = "First Name";
    private static final String lastName = "Last Name";
    private static final AddressEntity address = new AddressEntity();
    private static final long phoneNumber = 1234567890L;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity(
                username,
                password,
                userRole,
                firstName,
                lastName,
                address,
                phoneNumber);
    }

    @Test
    void testGetAuthorities() {
        Collection<? extends GrantedAuthority> authorities = userEntity.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority(userRole.name())));
    }

    @Test
    void testGetPassword() {
        assertEquals(password, userEntity.getPassword());
    }

    @Test
    void testGetUsername() {
        assertEquals(username, userEntity.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(userEntity.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(userEntity.isAccountNonLocked());

        // lock the acc and check again
        userEntity.setLocked(true);
        assertFalse(userEntity.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(userEntity.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertTrue(userEntity.isEnabled());

        // disable the acc and check again
        userEntity.setEnabled(false);
        assertFalse(userEntity.isEnabled());
    }
}