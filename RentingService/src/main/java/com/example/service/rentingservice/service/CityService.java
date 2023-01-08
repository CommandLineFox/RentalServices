package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.CityCreateDto;
import com.example.service.rentingservice.dto.CityDto;

public interface CityService {
    CityDto findCity(Long id);

    CityDto createCity(CityCreateDto cityCreateDto);

    CityDto updateCity(CityDto cityDto);

    void deleteCity(Long id);
}
