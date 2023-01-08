package com.example.service.rentingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RentingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentingServiceApplication.class, args);
    }

}
