package com.example.service.rentingservice.dto;

public class ReviewCreateDto {
    private Integer grade;
    private String comment;
    private FirmDto firm;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public FirmDto getFirm() {
        return firm;
    }

    public void setFirm(FirmDto firm) {
        this.firm = firm;
    }
}
