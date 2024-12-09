package org.rbnk.dealership.service;

import org.rbnk.dealership.dto.CarDto;
import org.rbnk.dealership.dto.CarPriceDto;

import java.util.List;

public interface CarService {

    CarDto findCarById(Long id);

    List<CarDto> findAll();

    void save(CarDto carDto);

    void fullUpdate(CarDto carDto);

    void priceUpdate(CarPriceDto carDto);

    void delete(Long id);
}
