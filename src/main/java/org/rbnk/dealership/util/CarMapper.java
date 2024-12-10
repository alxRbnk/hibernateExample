package org.rbnk.dealership.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rbnk.dealership.dto.CarDto;
import org.rbnk.dealership.entity.Car;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);
}
