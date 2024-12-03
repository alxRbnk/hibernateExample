package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.service.CarService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final EntityManager entityManager;

    public void saveCar(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    public void updateCar(Car car) {
        entityManager.getTransaction().begin();
        entityManager.merge(car);
        entityManager.getTransaction().commit();
    }

    public void deleteCar(Long id) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, id);
        if (car != null) {
            entityManager.remove(car);
        }
        entityManager.getTransaction().commit();
    }

    public Car getCarById(Long id) {
        Car car = entityManager.find(Car.class, id);
        return car;
    }

    public List<Car> getAllCars() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM Car c";
        Query query = entityManager.createQuery(jpqlQuery, Car.class);
        List<Car> cars = query.getResultList();
        entityManager.getTransaction().commit();
        return cars;
    }

    public List<Car> findCars(String brand, LocalDate year, Long categoryId, Double minPrice, Double maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);
        Predicate predicate = cb.conjunction();
        if (brand != null) {
            predicate = cb.and(predicate, cb.equal(car.get("model"), brand));
        }
        if (year != null) {
            predicate = cb.and(predicate, cb.equal(car.get("productionYear"), year));
        }
        if (categoryId != null) {
            predicate = cb.and(predicate, cb.equal(car.get("category").get("id"), categoryId));
        }
        if (minPrice != null) {
            predicate = cb.and(predicate, cb.greaterThanOrEqualTo(car.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(car.get("price"), maxPrice));
        }
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Car> findCarsWithSorting(String brand, Double minPrice, Double maxPrice, boolean ascending) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);
        Predicate predicate = cb.conjunction();
        if (brand != null) {
            predicate = cb.and(predicate, cb.equal(car.get("model"), brand));
        }
        if (minPrice != null) {
            predicate = cb.and(predicate, cb.greaterThanOrEqualTo(car.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(car.get("price"), maxPrice));
        }
        query.where(predicate);

        if (ascending) {
            query.orderBy(cb.asc(car.get("price")));
        } else {
            query.orderBy(cb.desc(car.get("price")));
        }
        return entityManager.createQuery(query).getResultList();
    }

    public List<Car> findCarsWithPagination(int offset, int limit) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);

        query.select(car);

        return entityManager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
