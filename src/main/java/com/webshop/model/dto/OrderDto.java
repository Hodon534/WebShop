package com.webshop.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing an order.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private long id;
    private List<OrderItemDto> orderItems;
    private String status;
    private LocalDateTime createdAt;
    private BigDecimal total;
    private long userId;

    public long getId() {
        return id;
    }

    public List<OrderItemDto> getOrderItems() {
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

    public long getUserId() {
        return userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
