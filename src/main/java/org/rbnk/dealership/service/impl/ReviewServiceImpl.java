package org.rbnk.dealership.service.impl;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AddReviewDto;
import org.rbnk.dealership.dto.ReviewDto;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.Client;
import org.rbnk.dealership.entity.Review;
import org.rbnk.dealership.exception.CustomException;
import org.rbnk.dealership.repository.CarRepository;
import org.rbnk.dealership.repository.ClientRepository;
import org.rbnk.dealership.repository.ReviewRepository;
import org.rbnk.dealership.service.ClientService;
import org.rbnk.dealership.service.ReviewService;
import org.rbnk.dealership.util.ReviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private static final String REVIEW_NOT_FOUND = "Review not found";
    private static final String CLIENT_NOT_FOUND = "Client not found";
    private static final String CAR_NOT_FOUND = "Car not found";
    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public ReviewDto findById(Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        Review review = reviewOptional.orElseThrow(() -> new CustomException(REVIEW_NOT_FOUND));
        return ReviewMapper.INSTANCE.reviewToDto(review);
    }

    public List<ReviewDto> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(ReviewMapper.INSTANCE::reviewToDto)
                .toList();
    }

    @Transactional
    public void save(ReviewDto reviewDto) {
        Review review = ReviewMapper.INSTANCE.dtoToReview(reviewDto);
        reviewRepository.save(review);
    }

    @Transactional
    public void update(ReviewDto reviewDto) {
        Long id = reviewDto.getId();
        reviewRepository.findById(id).orElseThrow(() -> new CustomException(REVIEW_NOT_FOUND));
        Review review = ReviewMapper.INSTANCE.dtoToReview(reviewDto);
        review.setId(id);
        reviewRepository.save(review);
    }

    @Transactional
    public void delete(Long id) {
        reviewRepository.findById(id).orElseThrow(() -> new CustomException(REVIEW_NOT_FOUND));
        reviewRepository.deleteById(id);
    }

    @Transactional
    public void addReviewToCar(AddReviewDto addReviewDto){
        Car car = carRepository.findById(addReviewDto.getCarId())
                .orElseThrow(() -> new CustomException(CAR_NOT_FOUND));
        Client client = clientRepository.findById(addReviewDto.getClientId())
                .orElseThrow(() -> new CustomException(CLIENT_NOT_FOUND));
        Review review = Review.builder()
                .text(addReviewDto.getText())
                .rating(addReviewDto.getRating())
                .car(car)
                .client(client)
                .build();
        reviewRepository.save(review);
    }
}
