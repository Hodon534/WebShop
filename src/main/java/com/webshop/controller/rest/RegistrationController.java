package com.webshop.controller.rest;

import com.webshop.mapper.RegistrationMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.service.RegistrationService;
import com.webshop.service.impl.RegistrationServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private RegistrationService registrationService;
    private RegistrationMapper registrationMapper;
    @PostMapping("/add")
    public void register(@Valid RegistrationRequestDto request) {  //(@RequestBody RegistrationRequestDto request) { //
        registrationService.register(registrationMapper.registrationRequestToUserEntity(request));
        log.info(LogConst.USER_NEW_REGISTERED_MESSAGE);
    }
}
