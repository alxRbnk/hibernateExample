package org.rbnk.dealership.service;

import org.rbnk.dealership.entity.Client;

import java.util.List;

public interface ClientService {
    void saveClient(Client client);

    void updateClient(Client client);

    void deleteClient(Long id);

    Client getClientById(Long id);

    List<Client> getAllClients();

    void assignCarToClient(Long carId, Long clientId);
}
