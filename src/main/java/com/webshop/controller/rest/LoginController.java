package com.webshop.controller.rest;

import com.webshop.model.constants.CrossOriginConst;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = CrossOriginConst.BASE_LINK)
public class LoginController {
}
