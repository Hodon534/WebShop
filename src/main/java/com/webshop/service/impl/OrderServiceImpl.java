package com.webshop.service.impl;

import com.webshop.exception.OrderException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.OrderEntity;
import com.webshop.repository.OrderRepository;
import com.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing orders.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    /**
     * Constructor to initialize the OrderService with a repository.
     *
     * @param orderRepository The repository for order management.
     */
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    /**
     * Retrieves all orders from the database.
     *
     * @return A list of OrderEntity objects representing orders.
     */
    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    /**
     * Saves an order entity in the database.
     *
     * @param orderEntity The OrderEntity to be saved.
     * @return The saved OrderEntity.
     */
    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    /**
     * Retrieves an order entity by its ID.
     *
     * @param id The ID of the order to retrieve.
     * @return The retrieved OrderEntity.
     * @throws OrderException If the order with the given ID doesn't exist.
     */
    @Override
    public OrderEntity find(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new OrderException(String.format(ExceptionConst.ORDER_NOT_FOUND_MESSAGE, id))
        );
    }
}
