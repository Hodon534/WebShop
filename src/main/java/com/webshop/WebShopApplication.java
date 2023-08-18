package com.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class to start the WebShop application.
 */
@SpringBootApplication
@ComponentScan({"com.webshop"})
public class WebShopApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

}
