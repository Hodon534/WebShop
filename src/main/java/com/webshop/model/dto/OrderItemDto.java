package com.webshop.model.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) representing an item within an order.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDto {
    private long id;
    private long productId;
    private String productName;
    private String productImage;
    private BigDecimal price;
    private long quantity;

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}
