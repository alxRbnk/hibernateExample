package org.rbnk.dealership.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AddReviewDto;
import org.rbnk.dealership.dto.ReviewDto;
import org.rbnk.dealership.service.ReviewService;
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
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewDto getById(@PathVariable("id") @NotNull Long id) {
        return reviewService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewDto> getAll() {
        return reviewService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody @Valid ReviewDto reviewDto) {
        reviewService.update(reviewDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull Long id) {
        reviewService.delete(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addReviewToCar(@RequestBody @Valid AddReviewDto addReviewDto){
        reviewService.addReviewToCar(addReviewDto);
    }


}

