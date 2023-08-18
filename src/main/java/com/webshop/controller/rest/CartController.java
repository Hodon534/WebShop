package com.webshop.controller.rest;

import com.webshop.mapper.CartToOrderMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.CartDto;
import com.webshop.model.dto.OrderDto;
import com.webshop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    private OrderService orderService;
    private CartToOrderMapper cartToOrderMapper;

    @PostMapping("/add")
    public void save(@RequestBody CartDto cartDto) {
        orderService.save(cartToOrderMapper.cartToOrder(cartDto));
        log.info(LogConst.ORDER_ADDED);
    }
}
