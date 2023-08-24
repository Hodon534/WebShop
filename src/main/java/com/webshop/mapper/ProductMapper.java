package com.webshop.mapper;

import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import com.webshop.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting between Product-related DTOs and entities.
 */
@AllArgsConstructor
@Component
public class ProductMapper {
    private ManufacturerService manufacturerService;
    /**
     * Converts a ProductEntity to a ProductCardDto.
     *
     * @param productEntity The ProductEntity to be converted.
     * @return A ProductCardDto representing the converted product.
     */
    public ProductCardDto entityToDto(ProductEntity productEntity) {
        return new ProductCardDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getManufacturer().getName(),
                productEntity.getManufacturer().getId(),
                productEntity.getCategory(),
                productEntity.getImage(),
                productEntity.getInventory().getCurrentPrice(),
                productEntity.getInventory().getInStock()
        );
    }

    /**
     * Converts a ProductCardDto to a new ProductEntity.
     *
     * @param productCardDto The ProductCardDto to be converted.
     * @return A ProductEntity representing the converted product DTO.
     */
        public ProductEntity dtoToNewEntity(ProductCardDto productCardDto) {
            ManufacturerEntity manufacturer = manufacturerService.find(productCardDto.getManufacturerId());
            return new ProductEntity(
                    productCardDto.getName(),
                    productCardDto.getDescription(),
                    manufacturer,
                    productCardDto.getCategory(),
                    new ProductInventoryEntity(
                            productCardDto.getPrice(),
                            productCardDto.getInStock()
                    ),
                    productCardDto.getImage()
            );
        }
}

