package com.example.service.rentalapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class RentalApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalApiGatewayApplication.class, args);
    }

}
