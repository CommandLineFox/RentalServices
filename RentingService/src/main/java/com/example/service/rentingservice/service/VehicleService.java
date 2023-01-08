package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.VehicleCreateDto;
import com.example.service.rentingservice.dto.VehicleDto;

public interface VehicleService {
    VehicleDto findVehicle(Long id);

    VehicleDto createVehicle(VehicleCreateDto vehicleCreateDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);
}
