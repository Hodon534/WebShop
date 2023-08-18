package com.webshop.model.entity;

import com.webshop.model.enums.Categories;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//todo Serializable review

/**
 * Items sold on the website
 */

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "items")
@Entity
public class ProductEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;
    private String manufacturer;
    @Column(nullable = false)
    private String category;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private ProductInventoryEntity inventory;
    /**
     * image url
     */
    private String image;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;


    public ProductEntity(String name, String description, String manufacturer, String category, ProductInventoryEntity productInventory, String image) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.inventory = productInventory;
        this.image = image;
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
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

    public ProductInventoryEntity getInventory() {
        return inventory;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public void setInventory(ProductInventoryEntity inventory) {
        this.inventory = inventory;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
