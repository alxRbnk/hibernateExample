package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.ShowroomDto;
import org.rbnk.dealership.entity.CarShowroom;
import org.rbnk.dealership.exception.CustomException;
import org.rbnk.dealership.repository.ShowroomRepository;
import org.rbnk.dealership.service.ShowroomService;
import org.rbnk.dealership.util.ShowroomMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowroomServiceImpl implements ShowroomService {
    private static final String NOT_FOUND = "Showroom not found";
    private final ShowroomRepository showroomRepository;

    public ShowroomDto findById(Long id) {
        Optional<CarShowroom> carOptional = showroomRepository.findById(id);
        CarShowroom showroom = carOptional.orElseThrow(() -> new CustomException(NOT_FOUND));
        return ShowroomMapper.INSTANCE.showroomToDto(showroom);
    }

    public List<ShowroomDto> findAll() {
        List<CarShowroom> showrooms = showroomRepository.findAll();
        return showrooms.stream()
                .map(ShowroomMapper.INSTANCE::showroomToDto)
                .toList();
    }

    @Transactional
    public void save(ShowroomDto showroomDto) {
        CarShowroom showroom = ShowroomMapper.INSTANCE.dtoToShowroom(showroomDto);
        showroomRepository.save(showroom);
    }

    @Transactional
    public void update(ShowroomDto showroomDto) {
        Long id = showroomDto.getId();
        showroomRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        CarShowroom carShowroom = ShowroomMapper.INSTANCE.dtoToShowroom(showroomDto);
        carShowroom.setId(id);
        showroomRepository.save(carShowroom);
    }

    @Transactional
    public void delete(Long id) {
        showroomRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        showroomRepository.deleteById(id);
    }
}
