package com.webshop.service;

import com.webshop.exception.OrderException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.OrderEntity;
import com.webshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntity save(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    public OrderEntity find(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new OrderException(String.format(ExceptionConst.ORDER_NOT_FOUND, id))
        );
    }
}
