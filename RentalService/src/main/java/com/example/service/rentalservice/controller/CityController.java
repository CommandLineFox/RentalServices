package com.example.service.rentalservice.controller;

import com.example.service.rentalservice.dto.CityCreateDto;
import com.example.service.rentalservice.dto.CityDto;
import com.example.service.rentalservice.listener.helper.MessageHelper;
import com.example.service.rentalservice.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;
    private final MessageHelper messageHelper;
    private final JmsTemplate jmsTemplate;
    private final String cityDestination;

    public CityController(CityService cityService, JmsTemplate jmsTemplate, MessageHelper messageHelper, @Value("${destination.createCity}") String cityDestination) {
        this.cityService = cityService;
        this.messageHelper = messageHelper;
        this.jmsTemplate = jmsTemplate;
        this.cityDestination = cityDestination;
    }

    @PostMapping("/create")
    public ResponseEntity<CityDto> createCity(@RequestBody CityCreateDto cityCreateDto) {
        jmsTemplate.convertAndSend(cityDestination, messageHelper.createTextMessage(cityCreateDto));
        return new ResponseEntity<>(cityService.createCity(cityCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.updateCity(cityDto), HttpStatus.OK);
    }
}
