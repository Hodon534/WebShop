package com.webshop.mapper;

import com.webshop.model.dto.CartDto;
import com.webshop.model.dto.CartItemDto;
import com.webshop.model.entity.*;
import com.webshop.model.enums.UserRole;
import com.webshop.service.ManufacturerService;
import com.webshop.service.ProductService;
import com.webshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CartToOrderMapperTest {

    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    private CartToOrderMapper underTest;

    private static final long productId = 2L;
    private static final long userId = 111L;


    @BeforeEach
    void setUp() {
        ProductEntity product = new ProductEntity(
                productId,
                "Products Name",
                "Products Description",
                new ManufacturerEntity(),
                "Products Category",
                new ProductInventoryEntity(
                        2L,
                        BigDecimal.valueOf(299L),
                        200L
                ),
                "Products Image",
                LocalDateTime.now()
        );
        UserEntity user = new UserEntity(
                userId,
                "Username",
                "Password",
                UserRole.USER,
                false,
                true,
                "First Name",
                "Last Name",
                new AddressEntity(
                        "Street",
                        "ZipCode",
                        "City",
                        "Country"
                ),
                8423942354254L,
                new ArrayList<>()
        );
        userService = mock(UserService.class);
        when(userService.find(userId)).thenReturn(user);
        productService = mock(ProductService.class);
        when(productService.find(productId)).thenReturn(product);
        underTest = new CartToOrderMapper(productService, userService);

    }

    @Test
    void cartToOrder() {
        // given
        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        CartDto cartDto = new CartDto(
                cartItemDtoList,
                userId
        );
        // when
        OrderEntity entity = underTest.cartToOrder(cartDto);

        // then
        assertEquals(userId, entity.getUser().getId());
    }

    @Test
    void cartItemToOrderItem() {
        // given
        BigDecimal productPrice = BigDecimal.valueOf(199L);
        long productQuantity = 4L;
        CartItemDto cartItemDto = new CartItemDto(
               productId,
               "",
               productPrice,
               productQuantity,
               ""
        );
        // when
        OrderItemEntity entity = underTest.cartItemToOrderItem(cartItemDto);
        // then

        assertAll(
                () -> assertEquals(productId, entity.getProduct().getId()),
                () -> assertEquals(productPrice, entity.getPrice()),
                () -> assertEquals(productQuantity, entity.getQuantity())
        );
    }
}