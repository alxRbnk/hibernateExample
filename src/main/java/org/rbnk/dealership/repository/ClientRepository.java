package org.rbnk.dealership.repository;

import org.rbnk.dealership.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    void deleteById(Long id);
}
