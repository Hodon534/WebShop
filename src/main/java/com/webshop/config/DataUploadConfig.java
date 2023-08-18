package com.webshop.config;

import com.webshop.util.DataUpload;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataUploadConfig {

    @Bean
    public CommandLineRunner populateData(DataUpload dataPopulationService) {
        return args -> dataPopulationService.populateProducts();

    }
}
