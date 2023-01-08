package com.example.service.rentingservice.mapper;

import com.example.service.rentingservice.domain.VehicleType;
import com.example.service.rentingservice.dto.VehicleTypeCreateDto;
import com.example.service.rentingservice.dto.VehicleTypeDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleTypeMapper {
    public VehicleTypeDto vehicleTypeToVehicleTypeDto(VehicleType vehicleType) {
        VehicleTypeDto vehicleTypeDto = new VehicleTypeDto();
        vehicleTypeDto.setId(vehicleType.getId());
        vehicleTypeDto.setName(vehicleTypeDto.getName());
        return vehicleTypeDto;
    }

    public VehicleType vehicleTypeCreateDtoToVehicleType(VehicleTypeCreateDto vehicleTypeCreateDto) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setName(vehicleTypeCreateDto.getName());
        return vehicleType;
    }
}
