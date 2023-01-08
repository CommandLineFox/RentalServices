package com.example.service.rentingservice.dto;

public class VehicleCreateDto {
    private String model;
    private Integer price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
