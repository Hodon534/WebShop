package com.webshop.service;

import com.webshop.model.entity.UserEntity;

public interface UserService {
    UserEntity find(Long id);
    UserEntity singUp(UserEntity user);
}
