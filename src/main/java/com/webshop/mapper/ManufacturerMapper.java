package com.webshop.mapper;

import com.webshop.model.dto.AddressDto;
import com.webshop.model.dto.ManufacturerDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.ManufacturerEntity;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {

    public ManufacturerDto entityToDto(ManufacturerEntity entity) {
        return new ManufacturerDto(
                entity.getId(),
                entity.getName(),
                new AddressDto(
                        entity.getAddress().getId(),
                        entity.getAddress().getStreet(),
                        entity.getAddress().getZipCode(),
                        entity.getAddress().getCity(),
                        entity.getAddress().getCountry()
                ),
                entity.getTaxCode()
        );
    }

    public ManufacturerEntity dtoToEntity(ManufacturerDto dto) {
        return new ManufacturerEntity(
                dto.getName(),
                new AddressEntity(
                        dto.getAddress().getStreet(),
                        dto.getAddress().getZipCode(),
                        dto.getAddress().getCity(),
                        dto.getAddress().getCountry()
                ),
                dto.getTaxCode()
        );
    }
}
  