package com.webshop.service.impl;

import com.webshop.model.entity.UserEntity;
import com.webshop.service.RegistrationService;
import com.webshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;

    @Override
    public void register(UserEntity userEntity){
        userService.singUp(userEntity);
    }
}
