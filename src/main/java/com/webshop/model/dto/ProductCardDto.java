package com.webshop.model.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) representing a product card.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductCardDto {
    private long id;
    private String name;
    private String description;
    private String manufacturer;
    private String category;
    private String image;
    private BigDecimal price;
    private long inStock;

    public ProductCardDto(String name, String description, String manufacturer, String category, String image, BigDecimal price, long inStock) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.image = image;
        this.price = price;
        this.inStock = inStock;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getInStock() {
        return inStock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setInStock(long inStock) {
        this.inStock = inStock;
    }
}
