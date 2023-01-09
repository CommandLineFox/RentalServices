package com.example.service.rentalservice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Firm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer vehicleCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "firm", orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "firm")
    private List<Vehicle> vehicles = new ArrayList<>();
    @ManyToOne
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(Integer vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
