package com.example.service.userservice.service;

import com.example.service.userservice.dto.*;

import java.util.List;

public interface UserService {

    List<UserDto> nadjiSveUsere();

    UserDto nadjiUsera(String id);

    UserDto dodajUsera(CreateUserDto createUserDto);

    UserDto azurirajUsera(UserDto userDto);

    UserDto banujUsera(String id);

    UserDto unbanujUsera(String id);

    UserDto register(UserDto userDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
