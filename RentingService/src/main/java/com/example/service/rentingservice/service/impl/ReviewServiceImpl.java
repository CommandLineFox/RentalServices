package com.example.service.rentingservice.service.impl;

import com.example.service.rentingservice.domain.Review;
import com.example.service.rentingservice.dto.ReviewCreateDto;
import com.example.service.rentingservice.dto.ReviewDto;
import com.example.service.rentingservice.mapper.ReviewMapper;
import com.example.service.rentingservice.repository.ReviewRepository;
import com.example.service.rentingservice.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewMapper reviewMapper;
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewRepository reviewRepository) {
        this.reviewMapper = reviewMapper;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewDto findReview(Long id) {
        return null;
    }

    @Override
    public ReviewDto createReview(ReviewCreateDto reviewCreateDto) {
        Review review = reviewMapper.reviewCreateDtoToReview(reviewCreateDto);
        reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        Review review = reviewRepository.getReferenceById(reviewDto.getId());
        if (reviewDto.getComment() != null) {
            review.setComment(reviewDto.getComment());
        }
        if (reviewDto.getGrade() != null) {
            review.setGrade(reviewDto.getGrade());
        }

        reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
