package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AssignCarDto;
import org.rbnk.dealership.dto.ClientDto;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.Client;
import org.rbnk.dealership.exception.CustomException;
import org.rbnk.dealership.repository.CarRepository;
import org.rbnk.dealership.repository.ClientRepository;
import org.rbnk.dealership.service.ClientService;
import org.rbnk.dealership.util.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private static final String CLIENT_NOT_FOUND = "Client not found";
    private static final String CAR_NOT_FOUND = "Car not found";
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    public ClientDto findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new CustomException(CLIENT_NOT_FOUND));
        return ClientMapper.INSTANCE.clientToDto(client);
    }

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper.INSTANCE::clientToDto)
                .toList();
    }

    @Transactional
    public void save(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.dtoToClient(clientDto);
        clientRepository.save(client);
    }

    @Transactional
    public void update(ClientDto clientDto) {
        Long id = clientDto.getId();
        clientRepository.findById(id).orElseThrow(() -> new CustomException(CLIENT_NOT_FOUND));
        Client client = ClientMapper.INSTANCE.dtoToClient(clientDto);
        client.setId(id);
        clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.findById(id).orElseThrow(() -> new CustomException(CLIENT_NOT_FOUND));
        clientRepository.deleteById(id);
    }

    @Transactional
    public void assignCarToClient(AssignCarDto assignCarDto){
        Long clientId = assignCarDto.getClientId();
        Long carId = assignCarDto.getCarId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomException(CLIENT_NOT_FOUND));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CustomException(CAR_NOT_FOUND));
        client.getCars().add(car);
        clientRepository.save(client);
    }
}
