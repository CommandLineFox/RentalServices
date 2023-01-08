package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.FirmCreateDto;
import com.example.service.rentingservice.dto.FirmDto;

public interface FirmService {
    FirmDto findFirm(Long id);

    FirmDto createFirm(FirmCreateDto firmCreateDto);

    FirmDto updateFirm(FirmDto firmDto);

    void deleteFirm(Long id);
}
