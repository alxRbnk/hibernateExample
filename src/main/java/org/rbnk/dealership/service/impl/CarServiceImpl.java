package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AddCarDto;
import org.rbnk.dealership.dto.CarDto;
import org.rbnk.dealership.dto.CarPriceDto;
import org.rbnk.dealership.entity.Car;
import org.rbnk.dealership.entity.CarShowroom;
import org.rbnk.dealership.exception.CustomException;
import org.rbnk.dealership.repository.CarRepository;
import org.rbnk.dealership.repository.ShowroomRepository;
import org.rbnk.dealership.service.CarService;
import org.rbnk.dealership.service.ShowroomService;
import org.rbnk.dealership.util.CarMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private static final String NOT_FOUND = "Car not found";
    private final CarRepository carRepository;
    private final ShowroomRepository showroomRepository;

    public CarDto findCarById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        Car car = carOptional.orElseThrow(() -> new CustomException(NOT_FOUND));
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper.INSTANCE::carToCarDto)
                .toList();
    }

    @Transactional
    public void save(CarDto carDto) {
        Car car = CarMapper.INSTANCE.carDtoToCar(carDto);
        carRepository.save(car);
    }

    @Transactional
    public void fullUpdate(CarDto carDto) {
        Long id = carDto.getId();
        carRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        Car car = CarMapper.INSTANCE.carDtoToCar(carDto);
        car.setId(id);
        carRepository.save(car);
    }

    @Transactional
    public void priceUpdate(CarPriceDto carDto) {
        Long id = carDto.getId();
        Car car = carRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        car.setId(id);
        car.setPrice(carDto.getPrice());
        carRepository.save(car);
    }

    @Transactional
    public void delete(Long id) {
        carRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        carRepository.deleteById(id);
    }

    @Transactional
    public void addShowroom(AddCarDto addCarDto) {
        Long carId = addCarDto.getCarId();
        Long showroomId = addCarDto.getShowroomId();
        Car car =
                carRepository.findById(carId).orElseThrow(()->new CustomException());
        CarShowroom carShowroom =
                showroomRepository.findById(showroomId).orElseThrow(() -> new CustomException());
        car.setCarShowroom(carShowroom);
        carRepository.save(car);
    }
}
