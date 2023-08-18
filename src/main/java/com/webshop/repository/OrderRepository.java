package com.webshop.repository;

import com.webshop.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing orders in the database.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
