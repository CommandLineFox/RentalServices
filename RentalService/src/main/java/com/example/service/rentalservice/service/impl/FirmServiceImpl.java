package com.example.service.rentalservice.service.impl;

import com.example.service.rentalservice.domain.City;
import com.example.service.rentalservice.domain.Firm;
import com.example.service.rentalservice.dto.FirmCreateDto;
import com.example.service.rentalservice.dto.FirmDto;
import com.example.service.rentalservice.mapper.FirmMapper;
import com.example.service.rentalservice.repository.FirmRepository;
import com.example.service.rentalservice.service.FirmService;
import org.springframework.stereotype.Service;

@Service
public class FirmServiceImpl implements FirmService {
    private FirmMapper firmMapper;
    private FirmRepository firmRepository;

    public FirmServiceImpl(FirmMapper firmMapper, FirmRepository firmRepository) {
        this.firmMapper = firmMapper;
        this.firmRepository = firmRepository;
    }

    @Override
    public FirmDto findFirm(Long id) {
        return null;
    }

    @Override
    public FirmDto createFirm(FirmCreateDto firmCreateDto) {
        Firm firm = firmMapper.firmCreateDtoToFirm(firmCreateDto);
        firmRepository.save(firm);
        return firmMapper.firmToFirmDto(firm);
    }

    @Override
    public FirmDto updateFirm(FirmDto firmDto) {
        Firm firm = firmRepository.getOne(firmDto.getId());
        if (firmDto.getName() != null) {
            firm.setName(firmDto.getName());
        }
        if (firmDto.getDescription() != null) {
            firm.setDescription(firmDto.getDescription());
        }
        if (firmDto.getVehicleCount() != null) {
            firm.setVehicleCount(firmDto.getVehicleCount());
        }

        firmRepository.save(firm);
        return firmMapper.firmToFirmDto(firm);
    }

    @Override
    public void deleteFirm(Long id) {
        firmRepository.deleteById(id);
    }
}
