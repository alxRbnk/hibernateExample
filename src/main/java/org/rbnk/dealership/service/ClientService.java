package org.rbnk.dealership.service;

import org.rbnk.dealership.dto.AssignCarDto;
import org.rbnk.dealership.dto.ClientDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientService {
    ClientDto findById(Long id);

    List<ClientDto> findAll();

    void save(ClientDto clientDto);

    void update(ClientDto clientDto);

    void delete(Long id);

    void assignCarToClient(AssignCarDto assignCarDto);
}
