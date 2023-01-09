package com.example.service.rentalservice.service;

import com.example.service.rentalservice.dto.VehicleCreateDto;
import com.example.service.rentalservice.dto.VehicleDto;

import java.text.ParseException;
import java.util.List;

public interface VehicleService {
    VehicleDto findVehicle(Long id);

    List<VehicleDto> listAvailableVehicles(String startDate, String endDate, String cityName, String firmName) throws ParseException;

    VehicleDto createVehicle(VehicleCreateDto vehicleCreateDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);
}
