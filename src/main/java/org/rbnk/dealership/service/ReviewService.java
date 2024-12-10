package org.rbnk.dealership.service;

import org.rbnk.dealership.dto.AddReviewDto;
import org.rbnk.dealership.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto findById(Long id);

    List<ReviewDto> findAll();

    void save(ReviewDto reviewDto);

    void update(ReviewDto reviewDto);

    void delete(Long id);

    void addReviewToCar(AddReviewDto addReviewDto);
}
