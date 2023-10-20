package com.webshop.controller.rest;

import com.webshop.model.constants.ApiConst;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/login")
@CrossOrigin(origins = ApiConst.CORS_BASE_LINK)
public class LoginController {
}
