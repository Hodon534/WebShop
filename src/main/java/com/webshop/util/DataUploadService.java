package com.webshop.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webshop.mapper.CartToOrderMapper;
import com.webshop.mapper.ManufacturerMapper;
import com.webshop.mapper.ProductMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.CartDto;
import com.webshop.model.dto.ManufacturerDto;
import com.webshop.model.dto.ProductCardDto;
import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.service.ManufacturerService;
import com.webshop.service.OrderService;
import com.webshop.service.ProductService;
import com.webshop.service.RegistrationService;
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
    private ManufacturerService manufacturerService;
    private ManufacturerMapper manufacturerMapper;
    private RegistrationService registrationService;
    private OrderService orderService;
    private CartToOrderMapper cartToOrderMapper;

    /**
     * Populates product data into the database from a JSON file.
     *
     * @throws IOException If there is an issue reading the JSON file.
     */
    public void populateProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("json/products.json");
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
        JsonNode productNode = rootNode.get("products");

        for (JsonNode product : productNode) {
            ProductCardDto productDto = objectMapper.treeToValue(product, ProductCardDto.class);
            productService.save(productMapper.dtoToNewEntity(productDto));
        }
        log.info(LogConst.DATABASE_PRODUCTS_UPDATED_MESSAGE);

    }

    public void populateManufacturers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("json/manufacturers.json");
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
        JsonNode manufacturerNode = rootNode.get("manufacturers");

        for (JsonNode manufacturer : manufacturerNode) {
            ManufacturerDto manufacturerDto = objectMapper.treeToValue(manufacturer, ManufacturerDto.class);
            manufacturerService.save(manufacturerMapper.dtoToEntity(manufacturerDto));
        }
        log.info(LogConst.DATABASE_MANUFACTURERS_UPDATED_MESSAGE);

    }

    public void populateUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("json/users.json");
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
        JsonNode userNode = rootNode.get("users");

        for (JsonNode user : userNode) {
            RegistrationRequestDto requestDto = objectMapper.treeToValue(user, RegistrationRequestDto.class);
            registrationService.register(requestDto);
        }
        log.info(LogConst.DATABASE_USERS_UPDATED_MESSAGE);

    }

    public void populateCarts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("json/carts.json");
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
        JsonNode cartNode = rootNode.get("carts");

        for (JsonNode cart : cartNode) {
            CartDto cartDto = objectMapper.treeToValue(cart, CartDto.class);
            orderService.save(cartToOrderMapper.cartToOrder(cartDto)
            );
        }
        log.info(LogConst.DATABASE_CARTS_UPDATED_MESSAGE);

    }
}
