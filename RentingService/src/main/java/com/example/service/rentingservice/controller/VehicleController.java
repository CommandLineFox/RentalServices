package com.example.service.rentingservice.controller;

import com.example.service.rentingservice.dto.VehicleCreateDto;
import com.example.service.rentingservice.dto.VehicleDto;
import com.example.service.rentingservice.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleCreateDto vehicleCreateDto) {
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleCreateDto), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDto), HttpStatus.OK);
    }
}
