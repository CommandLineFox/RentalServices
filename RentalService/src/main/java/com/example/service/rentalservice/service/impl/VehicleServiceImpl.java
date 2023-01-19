package com.example.service.rentalservice.service.impl;

import com.example.service.rentalservice.domain.Rent;
import com.example.service.rentalservice.domain.Vehicle;
import com.example.service.rentalservice.dto.VehicleCreateDto;
import com.example.service.rentalservice.dto.VehicleDto;
import com.example.service.rentalservice.listener.helper.MessageHelper;
import com.example.service.rentalservice.mapper.VehicleMapper;
import com.example.service.rentalservice.repository.RentRepository;
import com.example.service.rentalservice.repository.VehicleRepository;
import com.example.service.rentalservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private RentRepository rentRepository;
    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;
    private final MessageHelper messageHelper;
    private final JmsTemplate jmsTemplate;
    private final String vehicleListDestination;

    public VehicleServiceImpl(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository,
                              JmsTemplate jmsTemplate, MessageHelper messageHelper,
                              @Value("${destination.listVehicles}") String vehicleListDestination) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.vehicleListDestination = vehicleListDestination;
    }

    @Override
    public VehicleDto findVehicle(Long id) {
        return null;
    }

    @Override
    public List<VehicleDto> listAvailableVehicles(String startDate, String endDate) throws ParseException {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = filterByAvailability(vehicles, startDate, endDate);

        List<VehicleDto> vehicleDtoList = mapVehicles(vehicles);
        jmsTemplate.convertAndSend(vehicleListDestination, messageHelper.createTextMessage(vehicleDtoList));
        return vehicleDtoList;
    }

    @Override
    public VehicleDto createVehicle(VehicleCreateDto vehicleCreateDto) {
        Vehicle vehicle = vehicleMapper.vehicleCreateDtoToVehicle(vehicleCreateDto);
        vehicleRepository.save(vehicle);
        return vehicleMapper.vehicleToVehicleDto(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.getOne(vehicleDto.getId());
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
    @Transactional
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    private List<Vehicle> filterByAvailability(List<Vehicle> vehicles, String startDate, String endDate) throws ParseException {
        List<Vehicle> filtered = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            Rent rent = rentRepository.findRentByVehicle(vehicle.getModel());
            if (rent == null) {
                filtered.add(vehicle);
                continue;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date s1 = simpleDateFormat.parse(startDate);
            Date e1 = simpleDateFormat.parse(endDate);
            Date s2 = simpleDateFormat.parse(rent.getStartDate());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(s2);
            calendar.add(Calendar.DATE, +rent.getDuration()); //2 weeks
            Date e2 = calendar.getTime();

            if (s1.before(s2) && e1.after(s2) || s1.before(e2) && e1.after(e2) || s1.before(s2) && e1.after(e2) || s1.after(s2) && e1.before(e2)) {
                continue;
            }

            filtered.add(vehicle);
        }

        return filtered;
    }

    private List<VehicleDto> mapVehicles(List<Vehicle> vehicles) {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDtoList.add(vehicleMapper.vehicleToVehicleDto(vehicle));
        }

        return vehicleDtoList;
    }
}
