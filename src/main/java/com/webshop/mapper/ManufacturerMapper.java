package com.webshop.mapper;

import com.webshop.model.dto.AddressDto;
import com.webshop.model.dto.ManufacturerDto;
import com.webshop.model.entity.AddressEntity;
import com.webshop.model.entity.ManufacturerEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting between ManufacturerEntity and ManufacturerDto objects.
 */
@Component
public class ManufacturerMapper {

    /**
     * Converts a ManufacturerEntity object to a ManufacturerDto object.
     *
     * @param entity The ManufacturerEntity to be converted.
     * @return A ManufacturerDto representing the converted entity.
     */
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

    /**
     * Converts a ManufacturerDto object to a ManufacturerEntity object.
     *
     * @param dto The ManufacturerDto to be converted.
     * @return A ManufacturerEntity representing the converted dto.
     */
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
  