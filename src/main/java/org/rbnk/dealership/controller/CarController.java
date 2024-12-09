package org.rbnk.dealership.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.CarDto;
import org.rbnk.dealership.dto.CarPriceDto;
import org.rbnk.dealership.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getById(@PathVariable("id") @NotNull Long id) {
        return carService.findCarById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAll() {
        return carService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid CarDto carDto) {
        carService.save(carDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fullUpdate(@RequestBody @Valid CarDto carDto) {
        carService.fullUpdate(carDto);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void priceUpdate(@RequestBody @Valid CarPriceDto carDto) {
        carService.priceUpdate(carDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull Long id) {
        carService.delete(id);
    }
}
