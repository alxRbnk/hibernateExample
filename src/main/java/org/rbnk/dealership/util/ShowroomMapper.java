package org.rbnk.dealership.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rbnk.dealership.dto.ShowroomDto;
import org.rbnk.dealership.entity.CarShowroom;

@Mapper
public interface ShowroomMapper {
    ShowroomMapper INSTANCE = Mappers.getMapper(ShowroomMapper.class);

    ShowroomDto showroomToDto(CarShowroom carShowroom);

    CarShowroom dtoToShowroom(ShowroomDto showroomDto);
}
