package org.rbnk.dealership.service;

import org.rbnk.dealership.entity.CarShowroom;

import java.util.List;

public interface CarShowroomService {
    void saveCarShowroom(CarShowroom carShowroom);

    void updateCar(CarShowroom carShowroom);

    void deleteCar(Long id);

    CarShowroom getCarShowroomById(Long id);

    List<CarShowroom> getAllCarShowrooms();

    void addCarToShowroom(Long carId, Long showroomId);
}
