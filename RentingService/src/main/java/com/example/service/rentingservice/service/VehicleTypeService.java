package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.VehicleTypeCreateDto;
import com.example.service.rentingservice.dto.VehicleTypeDto;

public interface VehicleTypeService {
    VehicleTypeDto findVehicleType(Long id);

    VehicleTypeDto createVehicleType(VehicleTypeCreateDto vehicleTypeCreateDto);

    VehicleTypeDto updateVehicleType(VehicleTypeDto vehicleTypeDto);

    void deleteVehicleType(Long id);
}
