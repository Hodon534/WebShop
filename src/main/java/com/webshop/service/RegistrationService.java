package com.webshop.service;

import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void register(RegistrationRequestDto request){
        userService.singUp(
                new UserEntity(
                        request.getUsername(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        UserRole.USER,
                        request.getFirstName(),
                        request.getLastName(),
                        new AddressEntity(
                                request.getAddress().getStreet(),
                                request.getAddress().getZipCode(),
                                request.getAddress().getStreet(),
                                request.getAddress().getCountry()
                        ),
                        request.getPhoneNumber()
                ));
    }
}
