package com.webshop.service;

import com.webshop.model.entity.ManufacturerEntity;

import java.util.List;

public interface ManufacturerService {
    ManufacturerEntity find(long id);
    List<ManufacturerEntity> findAll();
    ManufacturerEntity save(ManufacturerEntity entity);
}
