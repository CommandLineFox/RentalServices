package com.example.service.rentingservice.service.impl;

import com.example.service.rentingservice.domain.VehicleType;
import com.example.service.rentingservice.dto.VehicleTypeCreateDto;
import com.example.service.rentingservice.dto.VehicleTypeDto;
import com.example.service.rentingservice.mapper.VehicleTypeMapper;
import com.example.service.rentingservice.repository.VehicleTypeRepository;
import com.example.service.rentingservice.service.VehicleTypeService;
import org.springframework.stereotype.Service;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private VehicleTypeMapper vehicleTypeMapper;
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeServiceImpl(VehicleTypeMapper vehicleTypeMapper, VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeMapper = vehicleTypeMapper;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public VehicleTypeDto findVehicleType(Long id) {
        return null;
    }

    @Override
    public VehicleTypeDto createVehicleType(VehicleTypeCreateDto vehicleTypeCreateDto) {
        VehicleType vehicleType = vehicleTypeMapper.vehicleTypeCreateDtoToVehicleType(vehicleTypeCreateDto);
        vehicleTypeRepository.save(vehicleType);
        return vehicleTypeMapper.vehicleTypeToVehicleTypeDto(vehicleType);
    }

    @Override
    public VehicleTypeDto updateVehicleType(VehicleTypeDto vehicleTypeDto) {
        VehicleType vehicleType = vehicleTypeRepository.getReferenceById(vehicleTypeDto.getId());
        if (vehicleTypeDto.getName() != null) {
            vehicleType.setName(vehicleTypeDto.getName());
        }

        vehicleTypeRepository.save(vehicleType);
        return vehicleTypeMapper.vehicleTypeToVehicleTypeDto(vehicleType);
    }

    @Override
    public void deleteVehicleType(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
