package com.example.service.rentalservice.listener;

import com.example.service.rentalservice.dto.CityCreateDto;
import com.example.service.rentalservice.listener.helper.MessageHelper;
import com.example.service.rentalservice.service.CityService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class CityListener {
    private final MessageHelper messageHelper;
    private final CityService cityService;

    public CityListener(MessageHelper messageHelper, CityService cityService) {
        this.messageHelper = messageHelper;
        this.cityService = cityService;
    }

    @JmsListener(destination = "${destination.createCity}", concurrency = "5-10")
    public void createCity(Message message) throws JMSException {
        CityCreateDto cityCreateDto = messageHelper.getMessage(message, CityCreateDto.class);
        cityCreateDto.setName("Testiranje");
        cityService.createCity(cityCreateDto);
    }
}
