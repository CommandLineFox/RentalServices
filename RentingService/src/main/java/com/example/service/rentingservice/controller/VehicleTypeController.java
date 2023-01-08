package com.example.service.rentingservice.controller;

import com.example.service.rentingservice.dto.VehicleTypeCreateDto;
import com.example.service.rentingservice.dto.VehicleTypeDto;
import com.example.service.rentingservice.service.VehicleTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle_type")
public class VehicleTypeController {
    private final VehicleTypeService vehicleTypeService;

    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleTypeDto> createVehicleType(@RequestBody VehicleTypeCreateDto vehicleTypeCreateDto) {
        return new ResponseEntity<>(vehicleTypeService.createVehicleType(vehicleTypeCreateDto), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleTypeDto> updateVehicleType(@RequestBody VehicleTypeDto vehicleTypeDto) {
        return new ResponseEntity<>(vehicleTypeService.updateVehicleType(vehicleTypeDto), HttpStatus.OK);
    }
}
