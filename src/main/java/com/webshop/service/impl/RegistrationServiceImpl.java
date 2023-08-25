package com.webshop.service.impl;

import com.webshop.model.entity.UserEntity;
import com.webshop.service.RegistrationService;
import com.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Implementation of the RegistrationService interface for user registration operations.
 */
@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;

    /**
     * Register a new user by delegating the registration process to the UserService.
     *
     * @param userEntity The UserEntity representing the user to be registered.
     */
    @Override
    public void register(UserEntity userEntity){
        userService.singUp(userEntity);
    }
}
