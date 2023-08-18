package com.webshop.model.entity;

import com.webshop.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "orders")
@Entity
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @PrimaryKeyJoinColumn(name = "order_items")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;
    private String status;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    private BigDecimal total;

    public OrderEntity(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
        status = Status.CREATED.name();
        createdAt = LocalDateTime.now();
        countTotal();
    }

    public Long getId() {
        return id;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    private void countTotal() {
        this.total = orderItems
                .stream()
                .map(entry -> entry.getPrice().multiply(BigDecimal.valueOf(entry.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
