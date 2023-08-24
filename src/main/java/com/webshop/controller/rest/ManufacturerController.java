package com.webshop.controller.rest;

import com.webshop.mapper.ManufacturerMapper;
import com.webshop.model.constants.LogConst;
import com.webshop.model.dto.ManufacturerDto;
import com.webshop.service.ManufacturerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/manufacturers")
@CrossOrigin(origins = "http://localhost:4200")
public class ManufacturerController {

    private ManufacturerMapper manufacturerMapper;
    private ManufacturerService manufacturerService;

    @GetMapping("/all")
    public List<ManufacturerDto> findAll() {
        return manufacturerService.findAll().stream().map(manufacturerMapper::entityToDto).toList();
    }


    @PostMapping("/add")
    public void save(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.save(manufacturerMapper.dtoToEntity(manufacturerDto));
        log.info(LogConst.MANUFACTURER_ADDED_MESSAGE);
    }
}