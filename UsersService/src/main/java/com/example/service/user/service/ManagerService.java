package com.example.service.user.service;

import com.example.service.user.dto.*;

import java.util.List;

public interface ManagerService {

    List<ManagerDto> nadjiSveManagere();

    ManagerDto nadjiManagera(String id);

    ManagerDto dodajManagera(CreateManagerDto createManagerDto);

    ManagerDto azurirajManagera(ManagerDto managerDto);

    ManagerDto banujManagera(String id);

    ManagerDto unbanujManagera(String id);

    void order(Long id, Integer count);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
