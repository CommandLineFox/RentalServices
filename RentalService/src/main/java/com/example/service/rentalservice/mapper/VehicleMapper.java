package com.example.service.rentalservice.mapper;

import com.example.service.rentalservice.domain.Vehicle;
import com.example.service.rentalservice.dto.VehicleCreateDto;
import com.example.service.rentalservice.dto.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public VehicleDto vehicleToVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setModel(vehicleDto.getModel());
        vehicleDto.setPrice(vehicleDto.getPrice());
        return vehicleDto;
    }

    public Vehicle vehicleCreateDtoToVehicle(VehicleCreateDto vehicleCreateDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleCreateDto.getModel());
        vehicle.setPrice(vehicleCreateDto.getPrice());
        return vehicle;
    }
}
