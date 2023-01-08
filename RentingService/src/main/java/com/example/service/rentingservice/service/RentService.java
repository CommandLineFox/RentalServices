package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.RentCreateDto;
import com.example.service.rentingservice.dto.RentDto;

public interface RentService {
    RentDto findRent(Long id);

    RentDto createRent(RentCreateDto rentCreateDto);

    RentDto updateRent(RentDto rentDto);

    void deleteRent(Long id);
}
