package org.rbnk.dealership.repository;

import org.rbnk.dealership.entity.CarShowroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowroomRepository extends JpaRepository<CarShowroom, Long> {
    void deleteById(Long id);
}
