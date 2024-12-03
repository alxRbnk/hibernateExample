package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.entity.Review;
import org.rbnk.dealership.service.ReviewService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final EntityManager entityManager;

    public void saveReview(Review review) {
        entityManager.getTransaction().begin();
        entityManager.persist(review);
        entityManager.getTransaction().commit();
    }

    public void updateReview(Review review) {
        entityManager.getTransaction().begin();
        entityManager.merge(review);
        entityManager.getTransaction().commit();
    }

    public void deleteReview(Long id) {
        entityManager.getTransaction().begin();
        Review review = entityManager.find(Review.class, id);
        if (review != null) {
            entityManager.remove(review);
        }
        entityManager.getTransaction().commit();
    }

    public Review getReviewById(Long id) {
        return entityManager.find(Review.class, id);
    }

    public List<Review> getAllReviews() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM Review c";
        Query query = entityManager.createQuery(jpqlQuery, Review.class);
        List<Review> reviews = query.getResultList();
        entityManager.getTransaction().commit();
        return reviews;
    }

    public List<Review> findReviewsByKeyword(String keyword) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> query = cb.createQuery(Review.class);
        Root<Review> review = query.from(Review.class);
        query.where(cb.like(review.get("text"), "%" + keyword + "%"));
        return entityManager.createQuery(query).getResultList();
    }
}
