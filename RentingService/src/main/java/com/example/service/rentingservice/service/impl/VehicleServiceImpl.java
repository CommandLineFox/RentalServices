package com.example.service.rentingservice.service.impl;

import com.example.service.rentingservice.domain.Vehicle;
import com.example.service.rentingservice.dto.VehicleCreateDto;
import com.example.service.rentingservice.dto.VehicleDto;
import com.example.service.rentingservice.mapper.VehicleMapper;
import com.example.service.rentingservice.repository.VehicleRepository;
import com.example.service.rentingservice.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleMapper vehicleMapper;
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDto findVehicle(Long id) {
        return null;
    }

    @Override
    public VehicleDto createVehicle(VehicleCreateDto vehicleCreateDto) {
        Vehicle vehicle = vehicleMapper.vehicleCreateDtoToVehicle(vehicleCreateDto);
        vehicleRepository.save(vehicle);
        return vehicleMapper.vehicleToVehicleDto(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.getReferenceById(vehicleDto.getId());
        if (vehicleDto.getModel() != null) {
            vehicle.setModel(vehicle.getModel());
        }
        if (vehicleDto.getPrice() != null) {
            vehicle.setPrice(vehicle.getPrice());
        }

        vehicleRepository.save(vehicle);
        return vehicleMapper.vehicleToVehicleDto(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
