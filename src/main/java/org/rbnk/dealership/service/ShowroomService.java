package org.rbnk.dealership.service;

import org.rbnk.dealership.dto.ShowroomDto;

import java.util.List;


public interface ShowroomService {

    ShowroomDto findById(Long id);

    List<ShowroomDto> findAll();

    void save(ShowroomDto showroomDto);

    void update(ShowroomDto showroomDto);

    void delete(Long id);

}
