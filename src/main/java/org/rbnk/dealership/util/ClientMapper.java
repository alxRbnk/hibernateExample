package org.rbnk.dealership.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rbnk.dealership.dto.ClientDto;
import org.rbnk.dealership.dto.ShowroomDto;
import org.rbnk.dealership.entity.CarShowroom;
import org.rbnk.dealership.entity.Client;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToDto(Client client);

    Client dtoToClient(ClientDto dto);
}
