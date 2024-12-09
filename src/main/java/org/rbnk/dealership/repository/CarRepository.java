package org.rbnk.dealership.repository;

import org.rbnk.dealership.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    void deleteById(Long id);
}
