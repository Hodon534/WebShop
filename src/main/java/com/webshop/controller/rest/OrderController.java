package com.webshop.controller.rest;

import com.webshop.mapper.OrderMapper;
import com.webshop.model.dto.OrderDto;
import com.webshop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller responsible for managing order-related operations.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private OrderService orderService;
    private OrderMapper orderMapper;

    /**
     * Retrieves a list of all orders.
     *
     * @return A list of OrderDto representing all orders.
     */
    @GetMapping("/all")
    public List<OrderDto> getAll() {
        return orderService.findAll().stream().map(orderMapper::toDto).toList();
    }

}
