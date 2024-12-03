package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.CarShowroom;
import org.rbnk.dealership.service.CarShowroomService;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class CarShowroomServiceImpl implements CarShowroomService {
    private final EntityManager entityManager;

    public void saveCarShowroom(CarShowroom carShowroom) {
        entityManager.getTransaction().begin();
        entityManager.persist(carShowroom);
        entityManager.getTransaction().commit();
    }

    public void updateCar(CarShowroom carShowroom) {
        entityManager.getTransaction().begin();
        entityManager.merge(carShowroom);
        entityManager.getTransaction().commit();
    }

    public void deleteCar(Long id) {
        entityManager.getTransaction().begin();
        CarShowroom carShowroom = entityManager.find(CarShowroom.class, id);
        if (carShowroom != null) {
            entityManager.remove(carShowroom);
        }
        entityManager.getTransaction().commit();
    }

    public CarShowroom getCarShowroomById(Long id) {
        CarShowroom carShowroom = entityManager.find(CarShowroom.class, id);
        return carShowroom;
    }

    public List<CarShowroom> getAllCarShowrooms() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM CarShowroom c";
        Query query = entityManager.createQuery(jpqlQuery, CarShowroom.class);
        List<CarShowroom> carShowrooms = query.getResultList();
        entityManager.getTransaction().commit();
        return carShowrooms;
    }

    public void addCarToShowroom(Long carId, Long showroomId) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, carId);
        CarShowroom showroom = entityManager.find(CarShowroom.class, showroomId);
        if (car != null && showroom != null) {
            car.setCarShowroom(showroom);
            entityManager.merge(car);
        }
        entityManager.getTransaction().commit();
    }

    public List<Car> getCarsFromShowroomWithJoinFetch(Long showroomId) {
        String jpqlQuery = "SELECT c FROM Car c JOIN FETCH c.carShowroom WHERE c.carShowroom.id = :showroomId";
        return entityManager.createQuery(jpqlQuery, Car.class)
                .setParameter("showroomId", showroomId)
                .getResultList();
    }

    public List<Car> getCarsFromShowroomWithCriteria(Long showroomId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);
        car.fetch("carShowroom");
        query.select(car).where(cb.equal(car.get("carShowroom").get("id"), showroomId));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Car> getCarsFromShowroomWithEntityGraph(Long showroomId) {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("Car.withShowroom");
        return entityManager.createQuery("SELECT c FROM Car c WHERE c.carShowroom.id = :showroomId", Car.class)
                .setParameter("showroomId", showroomId)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}
