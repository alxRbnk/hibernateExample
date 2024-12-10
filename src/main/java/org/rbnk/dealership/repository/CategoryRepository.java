package org.rbnk.dealership.repository;

import org.rbnk.dealership.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    void deleteById(Long id);
}
