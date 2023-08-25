package com.webshop.service;

import com.webshop.model.entity.ProductEntity;

import java.util.List;

/**
 * Service interface for managing products in the webshop.
 */
public interface ProductService {

    /**
     * Save or update a product in the database.
     *
     * @param productEntity The ProductEntity to be saved or updated.
     * @return The saved ProductEntity.
     */
    ProductEntity save(ProductEntity productEntity);

    /**
     * Retrieve a list of all products.
     *
     * @return A list of ProductEntity representing all products.
     */
    List<ProductEntity> findAll();

    /**
     * Find a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The ProductEntity representing the found product.
     */
    ProductEntity find(long id);

}
