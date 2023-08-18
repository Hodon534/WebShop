package com.webshop.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webshop.mapper.ProductMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.ProductCardDto;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Service responsible for populating product data from a JSON file into the database.
 */
@Slf4j
@AllArgsConstructor
@Component
public class DataUploadService {
    private ProductService productService;
    private ProductMapper productMapper;

    /**
     * Populates product data into the database from a JSON file.
     *
     * @throws IOException If there is an issue reading the JSON file.
     */
    public void populateProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("db.json");
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
        JsonNode productNode = rootNode.get("products");

        for (JsonNode product : productNode) {
            ProductCardDto productDto = objectMapper.treeToValue(product, ProductCardDto.class);
            productService.save(productMapper.dtoToNewEntity(productDto));
        }
        log.info(LogConst.DATABASE_UPDATED);

    }
}
