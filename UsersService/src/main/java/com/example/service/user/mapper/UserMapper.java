package com.example.service.user.mapper;

import com.example.service.user.domain.Manager;
import com.example.service.user.domain.User;
import com.example.service.user.dto.CreateManagerDto;
import com.example.service.user.dto.CreateUserDto;
import com.example.service.user.dto.ManagerDto;
import com.example.service.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class UserMapper {


    public UserDto userToUserDto(User user){

        UserDto userDto=new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setMail(user.getMail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());

        userDto.setPassportNumber(user.getPassportNumber());
        userDto.setTotalRentalsInDays(user.getTotalRentalsInDays());
        userDto.setZabrana(user.isZabrana());
        return userDto;
    }

    public User createUserDtoToUser(CreateUserDto createUserDto)
    {
        User user=new User();

        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());
        user.setMail(createUserDto.getMail());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        user.setDateOfBirth(createUserDto.getDateOfBirth());
        user.setName(createUserDto.getName());
        user.setSurname(createUserDto.getSurname());

        user.setPassportNumber(createUserDto.getPassportNumber());
        user.setTotalRentalsInDays(0);
        user.setZabrana(false);
        return user;
    }
}
