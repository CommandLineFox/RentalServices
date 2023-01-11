package com.example.service.user.controller;

import com.example.service.user.dto.*;
import com.example.service.user.exception.NotFoundException;
import com.example.service.user.service.AdminService;
import com.example.service.user.service.ManagerService;
import com.example.service.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    private final UserService userService;
    private final AdminService adminService;
    private final ManagerService managerService;

    public Controller(UserService userService, AdminService adminService, ManagerService managerService) {
        this.userService = userService;
        this.adminService = adminService;
        this.managerService = managerService;
    }

    //ADMIN
    @PostMapping("/admin/update")
    public ResponseEntity<AdminDto> updateUser(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(adminService.azurirajAdmina(adminDto), HttpStatus.OK);
    }

    @PostMapping("/admin/ban")
    public ResponseEntity<AdminDto> banUser(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(adminService.azurirajAdmina(adminDto), HttpStatus.OK);
    }

    //MANAGER
    @PostMapping("/manager/register")
    public ResponseEntity<ManagerDto> sendMailManager(@RequestBody CreateManagerDto createManagerDto) {
        return new ResponseEntity<>(managerService.dodajManagera(createManagerDto), HttpStatus.OK);
    }

    @PostMapping("/manager/update")
    ResponseEntity<ManagerDto> updateManager(@RequestBody ManagerDto ManagerDto) {
        return new ResponseEntity<>(managerService.azurirajManagera(ManagerDto), HttpStatus.OK);
    }

    @PostMapping("/manager/ban")
    ResponseEntity<ManagerDto> banManager(@RequestBody String ManagerId) {
        return new ResponseEntity<ManagerDto>(managerService.banujManagera(ManagerId), HttpStatus.OK);
    }

    //USER
    @PostMapping("/user/register")
    public ResponseEntity<UserDto> addUser(@RequestBody CreateUserDto createUserDto) {
        return new ResponseEntity<>(userService.dodajUsera(createUserDto), HttpStatus.OK);
    }

    @PostMapping("/user/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.azurirajUsera(userDto), HttpStatus.OK);
    }

    @PostMapping("/user/ban")
    //@CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
    public ResponseEntity<UserDto> banUser(@RequestBody String Json) {
        return new ResponseEntity<>(userService.banujUsera(Json), HttpStatus.OK);

    }

    //LOGIN
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody TokenRequestDto tokenRequestDto) {
        ResponseEntity<TokenResponseDto> res3 = new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
        if (res3.getBody() != null) {
            return res3;
        }

        ResponseEntity<TokenResponseDto> res2 = new ResponseEntity<>(managerService.login(tokenRequestDto), HttpStatus.OK);
        if (res2.getBody() != null) {
            return res2;
        }

        ResponseEntity<TokenResponseDto> res1 = new ResponseEntity<>(adminService.login(tokenRequestDto), HttpStatus.OK);
        if (res1.getBody() != null) {
            return res1;
        }

        throw new NotFoundException(String.format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(), tokenRequestDto.getPassword()));
    }
}
