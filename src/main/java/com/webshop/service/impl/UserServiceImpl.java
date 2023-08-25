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

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUsername(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    @Override
    public UserEntity find(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    @Override
    public UserEntity singUp(UserEntity user) {
        boolean userExist = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist) {
            throw new UserException(ExceptionConst.USER_ALREADY_REGISTERED_MESSAGE);
        }
        return userRepository.save(user);
    }

}
