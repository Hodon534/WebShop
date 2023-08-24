package com.webshop.exception;

import com.webshop.model.entity.ManufacturerEntity;

public class ManufacturerException extends RuntimeException {
    public ManufacturerException(String message) {
        super(message);
    }
}
