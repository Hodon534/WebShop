package com.webshop.controller.rest;

import com.webshop.mapper.ProductMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.ProductCardDto;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    @GetMapping("/all")
    public List<ProductCardDto> findAll() {
        return productService.findAll().stream().map(productMapper::entityToDto).toList();
    }

    @PostMapping("/add")
    public void save(@RequestBody ProductCardDto productCardDto) {
        productService.save(productMapper.dtoToNewEntity(productCardDto));
        log.info(LogConst.PRODUCT_ADDED);
    }

    @GetMapping("/find/id/{id}")
    public ProductCardDto findById(@PathVariable("id") long id) {
        return productMapper.entityToDto(productService.find(id));
    }




}