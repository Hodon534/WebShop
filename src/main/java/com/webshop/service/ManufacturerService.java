package com.webshop.service;

import com.webshop.exception.ManufacturerException;
import com.webshop.model.constants.ExceptionConst;
import com.webshop.model.entity.ManufacturerEntity;
import com.webshop.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerEntity find(long id) {
        return manufacturerRepository.findById(id).orElseThrow(
                () -> new ManufacturerException(String.format(ExceptionConst.MANUFACTURER_NOT_FOUND_MESSAGE, id))
        );
    }

    public List<ManufacturerEntity> findAll() {
        return manufacturerRepository.findAll();
    }

    public ManufacturerEntity save(ManufacturerEntity entity) {
        return manufacturerRepository.save(entity);
    }
}
