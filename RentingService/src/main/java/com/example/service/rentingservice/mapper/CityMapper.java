package com.example.service.rentingservice.mapper;

import com.example.service.rentingservice.domain.City;
import com.example.service.rentingservice.dto.CityCreateDto;
import com.example.service.rentingservice.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityDto cityToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }

    public City cityCreateDtoToCity(CityCreateDto cityCreateDto) {
        City city = new City();
        city.setName(cityCreateDto.getName());
        return city;
    }
}
