package com.webshop.service;

import com.webshop.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity save(ProductEntity productEntity);
    List<ProductEntity> findAll();
    ProductEntity find(long id);

}
