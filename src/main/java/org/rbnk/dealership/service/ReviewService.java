package org.rbnk.dealership.service;

import org.rbnk.dealership.entity.Review;

import javax.persistence.Query;
import java.util.List;

public interface ReviewService {
    public void saveReview(Review review);

    public void updateReview(Review review);

    public void deleteReview(Long id);

    public Review getReviewById(Long id);

    public List<Review> getAllReviews();

    public List<Review> findReviewsByKeyword(String keyword);
}
