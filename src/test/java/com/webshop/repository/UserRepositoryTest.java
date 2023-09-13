package com.webshop.repository;

import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//todo

@DataJpaTest // Test Repository
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Disabled
    @Test
    void itShouldCheckIfEmailExist() {
        // given
        String email = "someEmail@email.com";
        UserEntity user = new UserEntity(
                email,
                "password",
                UserRole.USER,
                "First Name",
                "Last Name",
                new AddressEntity(),
                1234235342L
        );
        underTest.save(user);
        // when
        Optional<UserEntity> optionalUser = underTest.findByUsername(email);
        // then
        assertTrue(optionalUser.isPresent());
        assertEquals(user, optionalUser.get());
    }
}