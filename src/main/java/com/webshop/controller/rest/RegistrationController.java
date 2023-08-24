package com.webshop.controller.rest;

import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private RegistrationService registrationService;
    @PostMapping("/add")
    public void register(@Valid RegistrationRequestDto request) {
        registrationService.register(request);
        log.info(LogConst.USER_NEW_REGISTERED_MESSAGE);
    }
}
