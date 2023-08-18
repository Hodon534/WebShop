package com.webshop.service;

import com.webshop.exception.ProductException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.ProductEntity;
import com.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity find(long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ProductException(String.format(ExceptionConst.PRODUCT_NOT_FOUND, id))
        );
    }
}
