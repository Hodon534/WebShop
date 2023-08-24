package com.webshop.config;

import com.webshop.util.DataUploadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class responsible for initializing data population during application startup.
 */
@Configuration
public class DataUploadConfig {

    /**
     * Creates a CommandLineRunner bean that triggers data population service.
     *
     * @param dataPopulationService The service responsible for populating data.
     * @return A CommandLineRunner instance.
     */
    @Bean
    public CommandLineRunner populateProductData(DataUploadService dataPopulationService) {
        return args -> {
            dataPopulationService.populateManufacturers();
            dataPopulationService.populateProducts();
            dataPopulationService.populateUsers();
            dataPopulationService.populateCarts();
        };

    }

}
