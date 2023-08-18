package com.webshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Entity that represents current Stocks
 */

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product_inventory")
@Entity
public class ProductInventoryEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "current_price")
    private BigDecimal currentPrice;
    @Column(name = "quantity")
    private long inStock;

    /**
     * @param currentPrice   (BigDecimal)
     * @param inStock (long) - quantity
     */
    public ProductInventoryEntity(BigDecimal currentPrice, long inStock) {
        this.currentPrice = currentPrice;
        this.inStock = inStock;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public long getInStock() {
        return inStock;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setInStock(long inStock) {
        this.inStock = inStock;
    }
}
