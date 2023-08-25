package com.webshop.service;

import com.webshop.model.entity.UserEntity;

/**
 * Service interface for user-related operations in the webshop.
 */
public interface UserService {

    /**
     * Find a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The UserEntity if found, or null otherwise.
     */
    UserEntity find(Long id);

    /**
     * Sign up a new user in the webshop.
     *
     * @param user The UserEntity representing the user to be signed up.
     * @return The UserEntity representing the signed-up user.
     */
    UserEntity singUp(UserEntity user);
}
