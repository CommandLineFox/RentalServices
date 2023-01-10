package com.example.service.rentalservice.controller;

import com.example.service.rentalservice.dto.FirmCreateDto;
import com.example.service.rentalservice.dto.FirmDto;
import com.example.service.rentalservice.service.FirmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firm")
public class FirmController {
    private final FirmService firmService;

    public FirmController(FirmService firmService) {
        this.firmService = firmService;
    }

    @PostMapping("/create")
    public ResponseEntity<FirmDto> createFirm(@RequestBody FirmCreateDto firmCreateDto) {
        return new ResponseEntity<>(firmService.createFirm(firmCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<FirmDto> updateFirm(@RequestBody FirmDto firmDto) {
        return new ResponseEntity<>(firmService.updateFirm(firmDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FirmDto>> listVehicles() {
        return new ResponseEntity<>(firmService.listAll(), HttpStatus.OK);
    }
}
