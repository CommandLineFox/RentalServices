package com.example.service.rentingservice.controller;

import com.example.service.rentingservice.dto.CityCreateDto;
import com.example.service.rentingservice.dto.CityDto;
import com.example.service.rentingservice.listener.helper.MessageHelper;
import com.example.service.rentingservice.service.CityService;
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
    private final MessageHelper messageHelper;

    public CityController(CityService cityService, MessageHelper messageHelper) {
        this.cityService = cityService;
        this.messageHelper = messageHelper; 
    }

    @PostMapping("/create")
    public ResponseEntity<CityDto> createCity(@RequestBody CityCreateDto cityCreateDto) {
        messageHelper.createTextMessage(cityCreateDto);
        return new ResponseEntity<>(cityService.createCity(cityCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.updateCity(cityDto), HttpStatus.OK);
    }
}
