package com.example.service.rentingservice.service;

import com.example.service.rentingservice.dto.ReviewCreateDto;
import com.example.service.rentingservice.dto.ReviewDto;

public interface ReviewService {
    ReviewDto findReview(Long id);

    ReviewDto createReview(ReviewCreateDto reviewCreateDto);

    ReviewDto updateReview(ReviewDto reviewDto);

    void deleteReview(Long id);
}
