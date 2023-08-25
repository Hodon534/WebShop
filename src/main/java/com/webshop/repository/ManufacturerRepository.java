package com.webshop.repository;

import com.webshop.model.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Manufacturer entities in the database.
 */
@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
}
