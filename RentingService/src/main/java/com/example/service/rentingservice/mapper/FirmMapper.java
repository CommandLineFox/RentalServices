package com.example.service.rentingservice.mapper;

import com.example.service.rentingservice.domain.Firm;
import com.example.service.rentingservice.dto.FirmCreateDto;
import com.example.service.rentingservice.dto.FirmDto;
import org.springframework.stereotype.Component;

@Component
public class FirmMapper {
    public FirmDto firmToFirmDto(Firm firm) {
        FirmDto firmDto = new FirmDto();
        firmDto.setId(firm.getId());
        firmDto.setName(firm.getName());
        firmDto.setDescription(firm.getDescription());
        firmDto.setVehicleCount(firm.getVehicleCount());
        return firmDto;
    }

    public Firm firmCreateDtoToFirm(FirmCreateDto firmCreateDto) {
        Firm firm = new Firm();
        firm.setName(firmCreateDto.getName());
        firm.setDescription(firmCreateDto.getDescription());
        firm.setVehicleCount(firmCreateDto.getVehicleCount());
        return firm;
    }
}
