package com.webshop.util;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webshop.mapper.ProductMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.entity.ProductEntity;
import com.webshop.model.entity.ProductInventoryEntity;
import com.webshop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class DataUpload {
    private ProductService productService;
    private ProductMapper productMapper;

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
