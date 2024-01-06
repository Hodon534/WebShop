package com.webshop.controller.rest;

import com.webshop.model.constants.ApiConst;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = ApiConst.CORS_BASE_LINK)
public class LoginController {

    @GetMapping("/login")
    void getLogin(UserDto user) {
        System.out.println(user.toString());
        log.info(String.format(LogConst.USER_LOGGED_IN, user.getUsername()));
    }
}
