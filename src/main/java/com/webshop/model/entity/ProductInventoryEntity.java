package com.webshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Entity class representing current stock information for products.
 */
@Setter
@Getter
@EqualsAndHashCode
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
     * Constructor to initialize product inventory with price and quantity.
     *
     * @param currentPrice The current price of the product.
     * @param inStock      The quantity of the product in stock.
     */
    public ProductInventoryEntity(BigDecimal currentPrice, long inStock) {
        this.currentPrice = currentPrice;
        this.inStock = inStock;
    }
}
