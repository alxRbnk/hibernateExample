package org.rbnk.dealership.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AddCarDto;
import org.rbnk.dealership.dto.ShowroomDto;
import org.rbnk.dealership.service.ShowroomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/showrooms")
public class ShowroomController {
    private final ShowroomService showroomService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowroomDto getById(@PathVariable("id") @NotNull Long id) {
        return showroomService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShowroomDto> getAll() {
        return showroomService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid ShowroomDto showroomDto) {
        showroomService.save(showroomDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody @Valid ShowroomDto showroomDto) {
        showroomService.update(showroomDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull Long id) {
        showroomService.delete(id);
    }

}
