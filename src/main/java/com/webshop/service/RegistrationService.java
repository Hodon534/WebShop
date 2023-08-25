package com.webshop.service;

import com.webshop.model.entity.UserEntity;

/**
 * Service interface for user registration in the webshop.
 */
public interface RegistrationService {

    /**
     * Register a new user in the webshop.
     *
     * @param userEntity The UserEntity representing the user to be registered.
     */
    void register(UserEntity userEntity);
}
