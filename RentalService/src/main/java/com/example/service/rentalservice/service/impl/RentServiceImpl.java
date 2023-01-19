package com.example.service.rentalservice.service.impl;

import com.example.service.rentalservice.domain.Rent;
import com.example.service.rentalservice.dto.RentCreateDto;
import com.example.service.rentalservice.dto.RentDeleteDto;
import com.example.service.rentalservice.dto.RentDto;
import com.example.service.rentalservice.listener.helper.MessageHelper;
import com.example.service.rentalservice.mapper.RentMapper;
import com.example.service.rentalservice.repository.RentRepository;
import com.example.service.rentalservice.service.RentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RentServiceImpl implements RentService {
    private final RentMapper rentMapper;
    private final RentRepository rentRepository;
    private final MessageHelper messageHelper;
    private final JmsTemplate jmsTemplate;
    private final String createRentDestination;
    private final String deleteRentDestination;

    public RentServiceImpl(RentMapper rentMapper, RentRepository rentRepository, JmsTemplate jmsTemplate, MessageHelper messageHelper, @Value("${destination.createRent}") String createRentDestination, @Value("${destination.deleteRent") String deleteRentDestination) {
        this.rentMapper = rentMapper;
        this.rentRepository = rentRepository;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.createRentDestination = createRentDestination;
        this.deleteRentDestination = deleteRentDestination;
    }

    @Override
    public RentDto findRent(Long id) {
        return null;
    }

    @Override
    public RentDto createRent(RentCreateDto rentCreateDto) {
        Rent rent = rentMapper.rentCreateDtoToRent(rentCreateDto);
        rentRepository.save(rent);
        jmsTemplate.convertAndSend(createRentDestination, messageHelper.createTextMessage(rentCreateDto));
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
    @Transactional
    public void deleteRent(Long id) {
        Rent rent = rentRepository.getOne(id);
        RentDeleteDto rentDeleteDto = rentMapper.rentToRentDeleteDto(rent);
        jmsTemplate.convertAndSend(deleteRentDestination, messageHelper.createTextMessage(rentDeleteDto));
        rentRepository.deleteById(id);
    }
}
