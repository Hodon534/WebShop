package com.webshop.service;

import com.webshop.exception.UserException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.UserEntity;
import com.webshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUsername(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    public UserEntity find(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserException(ExceptionConst.USER_NOT_FOUND_MESSAGE));
    }

    public UserEntity singUp(UserEntity user) {
        boolean userExist = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist) {
            throw new UserException(ExceptionConst.USER_ALREADY_REGISTERED_MESSAGE);
        }
        return userRepository.save(user);
    }

}
