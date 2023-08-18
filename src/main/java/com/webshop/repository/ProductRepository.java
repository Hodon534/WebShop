package com.webshop.repository;

import com.webshop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing products in the database.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
