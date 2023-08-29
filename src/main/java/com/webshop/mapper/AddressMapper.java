package com.webshop.mapper;

import com.webshop.model.dto.AddressDto;
import com.webshop.model.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto entityToDto(AddressEntity entity) {
        return new AddressDto(
                entity.getId(),
                entity.getStreet(),
                entity.getZipCode(),
                entity.getCity(),
                entity.getCountry()
        );
    }

    public AddressEntity dtoToEntity(AddressDto dto) {
        return new AddressEntity(
                dto.getStreet(),
                dto.getZipCode(),
                dto.getCity(),
                dto.getCountry()
        );
    }

}
