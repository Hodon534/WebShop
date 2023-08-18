package com.webshop.mapper;

import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper class responsible for converting between Product-related DTOs and entities.
 */
@Component
public class ProductMapper {

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
                productEntity.getManufacturer(),
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
            return new ProductEntity(
                    productCardDto.getName(),
                    productCardDto.getDescription(),
                    productCardDto.getManufacturer(),
                    productCardDto.getCategory(),
                    new ProductInventoryEntity(
                            productCardDto.getPrice(),
                            productCardDto.getInStock()
                    ),
                    productCardDto.getImage()
            );
        }
}

