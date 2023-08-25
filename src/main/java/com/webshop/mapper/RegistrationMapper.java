package com.webshop.mapper;

import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RegistrationMapper {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final UserRole defaultRole = UserRole.USER;

    public UserEntity registrationRequestToUserEntity(RegistrationRequestDto request) {
        return new UserEntity(
                request.getUsername(),
                bCryptPasswordEncoder.encode(request.getPassword()),
                defaultRole,
                request.getFirstName(),
                request.getLastName(),
                new AddressEntity(
                        request.getAddress().getStreet(),
                        request.getAddress().getZipCode(),
                        request.getAddress().getStreet(),
                        request.getAddress().getCountry()
                ),
                request.getPhoneNumber()
        );
    }
}
