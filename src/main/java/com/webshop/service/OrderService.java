package com.webshop.service;

import com.webshop.model.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> findAll();
    OrderEntity save(OrderEntity orderEntity);
    OrderEntity find(Long id);
}
