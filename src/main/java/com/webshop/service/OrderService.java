package com.webshop.service;

import com.webshop.model.entity.OrderEntity;

import java.util.List;

/**
 * Service interface for managing orders in the webshop.
 */
public interface OrderService {

    /**
     * Retrieve a list of all orders.
     *
     * @return A list of OrderEntity representing all orders.
     */
    List<OrderEntity> findAll();

    /**
     * Save or update an order in the database.
     *
     * @param orderEntity The OrderEntity to be saved or updated.
     * @return The saved OrderEntity.
     */
    OrderEntity save(OrderEntity orderEntity);

    /**
     * Find an order by its unique identifier.
     *
     * @param id The unique identifier of the order.
     * @return The OrderEntity representing the found order.
     */
    OrderEntity find(Long id);
}
