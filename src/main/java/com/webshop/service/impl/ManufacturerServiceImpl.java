package com.webshop.service.impl;

import com.webshop.exception.ManufacturerException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.repository.ManufacturerRepository;
import com.webshop.service.ManufacturerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ManufacturerService interface for managing manufacturer-related operations.
 */
@AllArgsConstructor
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    /**
     * Find a manufacturer by its unique identifier.
     *
     * @param id The unique identifier of the manufacturer to find.
     * @return The found ManufacturerEntity.
     * @throws ManufacturerException if the manufacturer with the specified ID is not found.
     */
    @Override
    public ManufacturerEntity find(long id) {
        return manufacturerRepository.findById(id).orElseThrow(
                () -> new ManufacturerException(String.format(ExceptionConst.MANUFACTURER_NOT_FOUND_MESSAGE, id))
        );
    }

    /**
     * Retrieve a list of all manufacturers in the database.
     *
     * @return A list of ManufacturerEntity objects representing all manufacturers.
     */
    @Override
    public List<ManufacturerEntity> findAll() {
        return manufacturerRepository.findAll();
    }

    /**
     * Save a new manufacturer entity to the database.
     *
     * @param entity The ManufacturerEntity to be saved.
     * @return The saved ManufacturerEntity.
     */
    @Override
    public ManufacturerEntity save(ManufacturerEntity entity) {
        return manufacturerRepository.save(entity);
    }
}
