package org.rbnk.dealership.service;

import org.rbnk.dealership.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(Long id);

    List<CategoryDto> findAll();

    void save(CategoryDto categoryDto);

    void update(CategoryDto categoryDto);

    void delete(Long id);
}
