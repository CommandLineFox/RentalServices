package com.example.service.rentingservice.service.impl;

import com.example.service.rentingservice.domain.City;
import com.example.service.rentingservice.domain.Firm;
import com.example.service.rentingservice.dto.FirmCreateDto;
import com.example.service.rentingservice.dto.FirmDto;
import com.example.service.rentingservice.mapper.FirmMapper;
import com.example.service.rentingservice.repository.FirmRepository;
import com.example.service.rentingservice.service.FirmService;
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
        Firm firm = firmRepository.getReferenceById(firmDto.getId());
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
