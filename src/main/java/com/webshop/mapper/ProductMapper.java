package com.webshop.mapper;

import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

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

