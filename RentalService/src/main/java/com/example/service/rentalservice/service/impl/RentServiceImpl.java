package com.example.service.rentalservice.service.impl;

import com.example.service.rentalservice.domain.Rent;
import com.example.service.rentalservice.dto.RentCreateDto;
import com.example.service.rentalservice.dto.RentDto;
import com.example.service.rentalservice.mapper.RentMapper;
import com.example.service.rentalservice.repository.RentRepository;
import com.example.service.rentalservice.service.RentService;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {
    private RentMapper rentMapper;
    private RentRepository rentRepository;

    public RentServiceImpl(RentMapper rentMapper, RentRepository rentRepository) {
        this.rentMapper = rentMapper;
        this.rentRepository = rentRepository;
    }

    @Override
    public RentDto findRent(Long id) {
        return null;
    }

    @Override
    public RentDto createRent(RentCreateDto rentCreateDto) {
        Rent rent = rentMapper.rentCreateDtoToRent(rentCreateDto);
        rentRepository.save(rent);
        return rentMapper.rentToRentDto(rent);
    }

    @Override
    public RentDto updateRent(RentDto rentDto) {
        Rent rent = rentRepository.getOne(rentDto.getId());
        if (rentDto.getDuration() != null) {
            rent.setDuration(rentDto.getDuration());
        }
        if (rentDto.getStartDate() != null) {
            rent.setStartDate(rentDto.getStartDate());
        }

        rentRepository.save(rent);
        return rentMapper.rentToRentDto(rent);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
