package com.example.service.rentingservice.listener;

import com.example.service.rentingservice.dto.CityCreateDto;
import com.example.service.rentingservice.listener.helper.MessageHelper;
import com.example.service.rentingservice.service.CityService;
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

    @JmsListener(destination = "???", concurrency = "5-10")
    public void createCity(Message message) throws JMSException {
        System.out.println("test");
        //CityCreateDto cityCreateDto = messageHelper.getMessage(message, CityCreateDto.class);
        //cityService.createCity(cityCreateDto);
    }
}
