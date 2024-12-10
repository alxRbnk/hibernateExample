package org.rbnk.dealership.repository;

import org.rbnk.dealership.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    void deleteById(Long id);
}
