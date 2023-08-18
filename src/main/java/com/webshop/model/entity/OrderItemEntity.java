package com.webshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "order_items")
@Entity
public class OrderItemEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductEntity product;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    public OrderItemEntity(ProductEntity product, BigDecimal price, Long quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
