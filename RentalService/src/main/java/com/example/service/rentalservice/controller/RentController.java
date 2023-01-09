package com.example.service.rentalservice.controller;

import com.example.service.rentalservice.dto.RentCreateDto;
import com.example.service.rentalservice.dto.RentDto;
import com.example.service.rentalservice.service.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping("/create")
    public ResponseEntity<RentDto> createRent(@RequestBody RentCreateDto rentCreateDto) {
        return new ResponseEntity<>(rentService.createRent(rentCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<RentDto> updateRent(@RequestBody RentDto rentDto) {
        return new ResponseEntity<>(rentService.updateRent(rentDto), HttpStatus.OK);
    }
}
