package com.example.service.rentalservice.service;

import com.example.service.rentalservice.dto.VehicleCreateDto;
import com.example.service.rentalservice.dto.VehicleDto;

public interface VehicleService {
    VehicleDto findVehicle(Long id);

    VehicleDto createVehicle(VehicleCreateDto vehicleCreateDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);
}
