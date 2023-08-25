package com.webshop.service.impl;

import com.webshop.exception.UserException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.UserEntity;
import com.webshop.repository.UserRepository;
import com.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService and UserDetailsService interfaces for user-related operations.
 */
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private UserRepository userRepository;

    /**
     * Load user details by username, required by the UserDetailsService interface.
     *
     * @param email The email (username) of the user to load.
     * @return UserDetails representing the loaded user.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUsername(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    /**
     * Find a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The UserEntity representing the found user.
     * @throws UserException If the user is not found.
     */
    @Override
    public UserEntity find(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    /**
     * Sign up a new user.
     *
     * @param user The UserEntity representing the user to sign up.
     * @return The signed-up UserEntity.
     * @throws UserException If a user with the same email already exists.
     */
    @Override
    public UserEntity singUp(UserEntity user) {
        boolean userExist = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist) {
            throw new UserException(ExceptionConst.USER_ALREADY_REGISTERED_MESSAGE);
        }
        return userRepository.save(user);
    }

}
