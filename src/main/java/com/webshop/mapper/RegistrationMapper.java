package com.webshop.mapper;

import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.UserEntity;
import com.webshop.model.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting RegistrationRequestDto objects to UserEntity objects.
 */
@AllArgsConstructor
@Component
public class RegistrationMapper {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AddressMapper addressMapper;
    private static final UserRole defaultRole = UserRole.USER;

    /**
     * Converts a RegistrationRequestDto object to a UserEntity object.
     *
     * @param request The RegistrationRequestDto to be converted.
     * @return A UserEntity representing the converted registration request.
     */
    public UserEntity registrationRequestToUserEntity(RegistrationRequestDto request) {
        return new UserEntity(
                request.getUsername(),
                bCryptPasswordEncoder.encode(request.getPassword()),
                defaultRole,
                request.getFirstName(),
                request.getLastName(),
                addressMapper.dtoToEntity(request.getAddress()),
                request.getPhoneNumber()
        );
    }
}
