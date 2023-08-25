package com.webshop.service;

import com.webshop.model.entity.ManufacturerEntity;

import java.util.List;

/**
 * Service interface for managing manufacturers in the webshop.
 */
public interface ManufacturerService {

    /**
     * Find a manufacturer by its unique identifier.
     *
     * @param id The unique identifier of the manufacturer.
     * @return The ManufacturerEntity representing the found manufacturer.
     */
    ManufacturerEntity find(long id);

    /**
     * Retrieve a list of all manufacturers.
     *
     * @return A list of ManufacturerEntity representing all manufacturers.
     */
    List<ManufacturerEntity> findAll();

    /**
     * Save or update a manufacturer in the database.
     *
     * @param entity The ManufacturerEntity to be saved or updated.
     * @return The saved ManufacturerEntity.
     */
    ManufacturerEntity save(ManufacturerEntity entity);
}
