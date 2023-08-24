package com.webshop.model.entity;

import com.webshop.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity class representing an order.
 */
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
    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    /**
     * Constructor to initialize the order with a list of items.
     *
     * @param orderItems The list of items in the order.
     */
    public OrderEntity(List<OrderItemEntity> orderItems, UserEntity user) {
        this.orderItems = orderItems;
        this.user = user;
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

    public UserEntity getUser() {
        return user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * Calculates and sets the total cost of the order based on the items.
     */
    private void countTotal() {
        this.total = orderItems
                .stream()
                .map(entry -> entry.getPrice().multiply(BigDecimal.valueOf(entry.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
