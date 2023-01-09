package com.example.service.rentalservice.controller;

import com.example.service.rentalservice.dto.CityCreateDto;
import com.example.service.rentalservice.dto.CityDto;
import com.example.service.rentalservice.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/create")
    public ResponseEntity<CityDto> createCity(@RequestBody CityCreateDto cityCreateDto) {
        return new ResponseEntity<>(cityService.createCity(cityCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.updateCity(cityDto), HttpStatus.OK);
    }
}
