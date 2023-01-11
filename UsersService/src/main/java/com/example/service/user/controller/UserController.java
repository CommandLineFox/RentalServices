package com.example.service.user.controller;


import com.example.service.user.dto.*;
import com.example.service.user.security.CheckSecurity;
import com.example.service.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/user")
public class UserController {
/*
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody CreateUserDto createUserDto)
    {
        return new ResponseEntity<>(userService.dodajUsera(createUserDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.azurirajUsera(userDto), HttpStatus.OK);
    }

    @PostMapping("/ban")
   // @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
    public ResponseEntity<UserDto> banUser(@RequestBody String Json)
    {
        return new ResponseEntity<>(userService.banujUsera(Json), HttpStatus.OK);

    }*/
}
