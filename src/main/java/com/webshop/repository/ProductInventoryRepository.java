package com.webshop.repository;

import com.webshop.model.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing product inventory information in the database.
 */
@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventoryEntity, Long> {
}
