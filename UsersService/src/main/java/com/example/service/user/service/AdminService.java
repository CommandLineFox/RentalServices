package com.example.service.user.service;

import com.example.service.user.dto.AdminDto;
import com.example.service.user.dto.CreateAdminDto;
import com.example.service.user.dto.TokenRequestDto;
import com.example.service.user.dto.TokenResponseDto;

import java.util.List;

public interface AdminService {

    List<AdminDto> nadjiSveAdmine();

    AdminDto nadjiAdmina(String id);

    AdminDto dodajAdmina(CreateAdminDto createAdminDto);

    AdminDto azurirajAdmina(AdminDto adminDto);

    Boolean ukloniAdmina(String id);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
