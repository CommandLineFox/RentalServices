package com.example.service.user.dto;

public class CreateRankDto {
    private int numberOfDays;
    private String rankName;
    private String discount;

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
