package com.webshop.service.impl;

import com.webshop.exception.ProductException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.ProductEntity;
import com.webshop.repository.ProductRepository;
import com.webshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing products.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    /**
     * Constructor to initialize the ProductService with a repository.
     *
     * @param productRepository The repository for product management.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Saves a product entity in the database.
     *
     * @param productEntity The ProductEntity to be saved.
     * @return The saved ProductEntity.
     */
    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return A list of ProductEntity objects representing products.
     */
    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product entity by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved ProductEntity.
     * @throws ProductException If the product with the given ID doesn't exist.
     */
    @Override
    public ProductEntity find(long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ProductException(String.format(ExceptionConst.PRODUCT_NOT_FOUND_MESSAGE, id))
        );
    }
}
