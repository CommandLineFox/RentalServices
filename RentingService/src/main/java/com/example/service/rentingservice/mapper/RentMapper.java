package com.example.service.rentingservice.mapper;

import com.example.service.rentingservice.domain.Rent;
import com.example.service.rentingservice.dto.RentCreateDto;
import com.example.service.rentingservice.dto.RentDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RentMapper {
    public RentDto rentToRentDto(Rent rent) {
        RentDto rentDto = new RentDto();
        rentDto.setId(rent.getId());
        rentDto.setDuration(rent.getDuration());
        rentDto.setStartDate(rent.getStartDate());
        return rentDto;
    }

    public Rent rentCreateDtoToRent(RentCreateDto rentCreateDto) {
        Rent rent = new Rent();
        rent.setDuration(rent.getDuration());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime localDateTime = LocalDateTime.now();
        rent.setStartDate(dateTimeFormatter.format(localDateTime));
        return rent;
    }
}
