package com.example.service.user.controller;


import com.example.service.user.dto.*;
import com.example.service.user.listener.helper.MessageHelper;
import com.example.service.user.service.ManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/manager")
public class ManagerController {
/*
    private ManagerService managerService;
    private JmsTemplate jmsTemplate;
    private MessageHelper messageHelper;
    private String orderDestination;

    public ManagerController(ManagerService managerService, JmsTemplate jmsTemplate, MessageHelper messageHelper,
                             @Value("${destination.createOrder}") String orderDestination) {
        this.managerService = managerService;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.orderDestination = orderDestination;}

    @PostMapping("/register")
    public ResponseEntity<ManagerDto> sendMailManager(@RequestBody CreateManagerDto createManagerDto)
    {
        return new ResponseEntity<>(managerService.dodajManagera(createManagerDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    ResponseEntity<ManagerDto> updateManager(@RequestBody ManagerDto ManagerDto)
    {
        return new ResponseEntity<>(managerService.azurirajManagera(ManagerDto), HttpStatus.OK);
    }

    @PostMapping("/ban")
    ResponseEntity<ManagerDto> banManager(@RequestBody String ManagerId)
    {
        return new ResponseEntity<ManagerDto>(managerService.banujManagera(ManagerId), HttpStatus.OK);
    }

    @PostMapping("/mailrespond")
    public ResponseEntity<ManagerDto> addManager(@RequestBody ManagerDto managerDto)
    {  jmsTemplate.convertAndSend(orderDestination, messageHelper.createTextMessage(new CreateOrderDto(managerDto.getManagerId(),Long.valueOf(4))));
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
