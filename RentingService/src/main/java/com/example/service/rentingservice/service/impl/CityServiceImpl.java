package com.example.service.rentingservice.service.impl;

import com.example.service.rentingservice.domain.City;
import com.example.service.rentingservice.dto.CityCreateDto;
import com.example.service.rentingservice.dto.CityDto;
import com.example.service.rentingservice.mapper.CityMapper;
import com.example.service.rentingservice.repository.CityRepository;
import com.example.service.rentingservice.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private CityMapper cityMapper;
    private CityRepository cityRepository;

    public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDto findCity(Long id) {
        return null;
    }

    @Override
    public CityDto createCity(CityCreateDto cityCreateDto) {
        City city = cityMapper.cityCreateDtoToCity(cityCreateDto);
        cityRepository.save(city);
        return cityMapper.cityToCityDto(city);
    }

    @Override
    public CityDto updateCity(CityDto cityDto) {
        City city = cityRepository.getReferenceById(cityDto.getId());
        if (cityDto.getName() != null) {
            city.setName(cityDto.getName());
        }

        cityRepository.save(city);
        return cityMapper.cityToCityDto(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
