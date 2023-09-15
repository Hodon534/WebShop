package com.webshop.controller.rest;

import com.webshop.mapper.CartToOrderMapper;
import com.webshop.model.constants.ApiConst;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.CartDto;
import com.webshop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for managing shopping cart operations.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin(origins = ApiConst.CORS_BASE_LINK)
public class CartController {

    private OrderService orderService;
    private CartToOrderMapper cartToOrderMapper;

    /**
     * Saves a cart as an order.
     *
     * @param cartDto The cart data to be saved as an order.
     */
    @PostMapping("/add")
    public void save(@RequestBody CartDto cartDto) {
        orderService.save(cartToOrderMapper.cartToOrder(cartDto));
        log.info(LogConst.ORDER_ADDED_MESSAGE);

    }
}
