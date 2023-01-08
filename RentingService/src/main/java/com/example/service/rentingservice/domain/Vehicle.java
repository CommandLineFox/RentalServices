package com.example.service.rentingservice.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleType> vehicleType;
    @ManyToOne
    private Firm firm;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<VehicleType> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<VehicleType> vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
