package com.webshop.controller.rest;

import com.webshop.mapper.ProductMapper;
import com.webshop.model.constants.CrossOriginConst;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.ProductCardDto;
import com.webshop.service.ProductService;
import com.webshop.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller responsible for managing product-related operations.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = CrossOriginConst.BASE_LINK)
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    /**
     * Retrieves a list of all products.
     *
     * @return A list of ProductCardDto representing all products.
     */
    @GetMapping("/all")
    public List<ProductCardDto> findAll() {
        return productService.findAll().stream().map(productMapper::entityToDto).toList();
    }

    /**
     * Saves a new product.
     *
     * @param productCardDto The product data to be saved.
     */
    @PostMapping("/add")
    public void save(@RequestBody ProductCardDto productCardDto) {
        productService.save(productMapper.dtoToNewEntity(productCardDto));
        log.info(LogConst.PRODUCT_ADDED_MESSAGE);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The ProductCardDto representing the found product.
     */
    @GetMapping("/find/id/{id}")
    public ProductCardDto findById(@PathVariable("id") long id) {
        return productMapper.entityToDto(productService.find(id));
    }




}
