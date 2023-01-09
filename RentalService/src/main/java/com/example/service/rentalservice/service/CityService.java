package com.example.service.rentalservice.service;

import com.example.service.rentalservice.dto.CityCreateDto;
import com.example.service.rentalservice.dto.CityDto;

public interface CityService {
    CityDto findCity(Long id);

    CityDto createCity(CityCreateDto cityCreateDto);

    CityDto updateCity(CityDto cityDto);

    void deleteCity(Long id);
}
