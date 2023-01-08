package com.example.service.rentingservice.mapper;

import com.example.service.rentingservice.domain.Vehicle;
import com.example.service.rentingservice.dto.VehicleCreateDto;
import com.example.service.rentingservice.dto.VehicleDto;
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
