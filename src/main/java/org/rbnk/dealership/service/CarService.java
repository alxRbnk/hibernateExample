package org.rbnk.dealership.service;

import org.rbnk.dealership.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long id);

    Car getCarById(Long id);

    List<Car> getAllCars();

    List<Car> findCars(String brand, LocalDate year, Long categoryId, Double minPrice, Double maxPrice);

    List<Car> findCarsWithSorting(String brand, Double minPrice, Double maxPrice, boolean ascending);

    List<Car> findCarsWithPagination(int offset, int limit);
}
