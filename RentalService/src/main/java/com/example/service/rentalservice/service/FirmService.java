package com.example.service.rentalservice.service;

import com.example.service.rentalservice.dto.FirmCreateDto;
import com.example.service.rentalservice.dto.FirmDto;

public interface FirmService {
    FirmDto findFirm(Long id);

    FirmDto createFirm(FirmCreateDto firmCreateDto);

    FirmDto updateFirm(FirmDto firmDto);

    void deleteFirm(Long id);
}
