package com.example.service.user.controller;

import com.example.service.user.dto.AdminDto;
import com.example.service.user.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/admin")
public class AdminController {
/*
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<AdminDto>> getAll(){
        return new ResponseEntity<>(adminService.nadjiSveAdmine(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<AdminDto> updateUser(@RequestBody AdminDto adminDto)
    {
        return new ResponseEntity<>(adminService.azurirajAdmina(adminDto), HttpStatus.OK);
    }

    @PostMapping("/ban")
    public ResponseEntity<AdminDto> banUser(@RequestBody AdminDto adminDto)
    {

        return new ResponseEntity<>(adminService.azurirajAdmina(adminDto), HttpStatus.OK);
    }
   /* @PostMapping
    public ResponseEntity<AdminDto> addAdmin(@RequestBody CreateAdminDto createAdminDto)
    {
        return new ResponseEntity<>(adminService.dodajAdmina(createAdminDto), HttpStatus.OK);
    }*/
}
