package com.example.service.userservice.service.impl;

import com.example.service.userservice.domain.User;
import com.example.service.userservice.dto.CreateUserDto;
import com.example.service.userservice.dto.TokenRequestDto;
import com.example.service.userservice.dto.TokenResponseDto;
import com.example.service.userservice.dto.UserDto;
import com.example.service.userservice.exception.NotFoundException;
import com.example.service.userservice.listener.helper.MessageHelper;
import com.example.service.userservice.mapper.UserMapper;
import com.example.service.userservice.repository.UserRepository;
import com.example.service.userservice.security.service.TokenService;
import com.example.service.userservice.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final TokenService tokenService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final MessageHelper messageHelper;
    private final JmsTemplate jmsTemplate;
    private final String userDestination;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, TokenService tokenService, MessageHelper messageHelper, JmsTemplate jmsTemplate, @Value("${destination.sendNotification}") String userDestination) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.messageHelper = messageHelper;
        this.jmsTemplate = jmsTemplate;
        this.userDestination = userDestination;
    }

    @Override
    public List<UserDto> nadjiSveUsere() {
        return null;
    }

    @Override
    public UserDto nadjiUsera(String id) {
        return null;
    }

    @Override
    public UserDto dodajUsera(CreateUserDto createUserDto) {
        User user = userMapper.createUserDtoToUser(createUserDto);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto azurirajUsera(UserDto userDto) {
        User user = userRepository.getOne((long) userDto.getUserId());

        if (userDto.getUsername() != null)
            user.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null)
            user.setPassword(userDto.getPassword());
        if (userDto.getMail() != null)
            user.setMail(userDto.getMail());
        if (userDto.getPhoneNumber() != null)
            user.setPhoneNumber(userDto.getPhoneNumber());
        if (userDto.getDateOfBirth() != null)
            user.setDateOfBirth(userDto.getDateOfBirth());
        if (userDto.getName() != null)
            user.setName(userDto.getName());
        if (userDto.getSurname() != null)
            user.setSurname(userDto.getSurname());
        if (userDto.getPassportNumber() != null)
            user.setPassportNumber(userDto.getPassportNumber());

        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto banujUsera(String id) {
        User user = userRepository.getOne(Long.valueOf(id));
        user.setZabrana(true);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto unbanujUsera(String id) {
        User user = userRepository.getOne(Long.valueOf(id));
        user.setZabrana(false);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto register(UserDto userDto) {
        jmsTemplate.convertAndSend(userDestination, messageHelper.createTextMessage(userDto));
        return null;
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                tokenRequestDto.getPassword())));

        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getUserId());
        claims.put("role", "ROLE_USER");
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }
}
