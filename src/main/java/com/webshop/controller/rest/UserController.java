package com.webshop.controller.rest;

import com.webshop.model.constants.ApiConst;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = ApiConst.CORS_BASE_LINK)
public class UserController {

    @GetMapping("/logged")
    public UserDetails getLoggedInUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
