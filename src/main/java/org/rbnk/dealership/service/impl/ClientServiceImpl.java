package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.Client;
import org.rbnk.dealership.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.getTransaction().begin();
        client.setRegistrationDate(LocalDate.now());
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public void updateClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    public void deleteClient(Long id) {
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
        entityManager.getTransaction().commit();
    }

    public Client getClientById(Long id) {
        return entityManager.find(Client.class, id);
    }

    public List<Client> getAllClients() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM Client c";
        Query query = entityManager.createQuery(jpqlQuery, Client.class);
        List<Client> clients = query.getResultList();
        entityManager.getTransaction().commit();
        return clients;
    }

    public void assignCarToClient(Long carId, Long clientId) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, carId);
        Client client = entityManager.find(Client.class, clientId);
        if (car != null && client != null) {
            client.getCars().add(car);
            entityManager.merge(client);
        }
        entityManager.getTransaction().commit();
    }
}
