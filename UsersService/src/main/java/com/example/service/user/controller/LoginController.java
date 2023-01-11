package com.example.service.user.controller;

import com.example.service.user.dto.TokenRequestDto;
import com.example.service.user.dto.TokenResponseDto;
import com.example.service.user.exception.NotFoundException;
import com.example.service.user.security.CheckSecurity;
import com.example.service.user.service.AdminService;
import com.example.service.user.service.ManagerService;
import com.example.service.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/login")
public class LoginController {
   /* private UserService userService;
    private AdminService adminService;
    private ManagerService managerService;

    public LoginController(UserService userService, AdminService adminService, ManagerService managerService) {
        this.userService = userService;
        this.adminService = adminService;
        this.managerService = managerService;
    }

    @PostMapping
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid TokenRequestDto tokenRequestDto) {

        ResponseEntity<TokenResponseDto> res3 = new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
        if(res3.getBody()!=null) {
            return res3;
        }

        ResponseEntity<TokenResponseDto> res2 = new ResponseEntity<>(managerService.login(tokenRequestDto), HttpStatus.OK);
        if(res2.getBody()!=null) {
            return res2;
        }

        ResponseEntity<TokenResponseDto> res1 = new ResponseEntity<>(adminService.login(tokenRequestDto), HttpStatus.OK);
        if(res1.getBody()!=null) {
            return res1;
        }

        throw new NotFoundException(String
                .format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                        tokenRequestDto.getPassword()));
    }*/
}
