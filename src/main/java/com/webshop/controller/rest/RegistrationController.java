package com.webshop.controller.rest;

import com.webshop.mapper.RegistrationMapper;
import com.webshop.model.constants.ApiConst;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.RegistrationRequestDto;
import com.webshop.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for managing register-related operations.
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration")
@CrossOrigin(origins = ApiConst.CORS_BASE_LINK)
public class RegistrationController {
    private RegistrationService registrationService;
    private RegistrationMapper registrationMapper;
    @PostMapping("/add")
    public void register(@Valid RegistrationRequestDto request) {  //(@RequestBody RegistrationRequestDto request) { //
        registrationService.register(registrationMapper.registrationRequestToUserEntity(request));
        log.info(LogConst.USER_NEW_REGISTERED_MESSAGE);
    }
}
