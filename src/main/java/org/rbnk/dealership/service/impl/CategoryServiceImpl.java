package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.CategoryDto;
import org.rbnk.dealership.entity.Category;
import org.rbnk.dealership.exception.CustomException;
import org.rbnk.dealership.repository.CategoryRepository;
import org.rbnk.dealership.service.CategoryService;
import org.rbnk.dealership.util.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private static final String NOT_FOUND = "Category not found";
    private final CategoryRepository categoryRepository;

    public CategoryDto findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category category = categoryOptional.orElseThrow(() -> new CustomException(NOT_FOUND));
        return CategoryMapper.INSTANCE.categoryToDto(category);
    }

    public List<CategoryDto> findAll() {
        List<Category> category = categoryRepository.findAll();
        return category.stream()
                .map(CategoryMapper.INSTANCE::categoryToDto)
                .toList();
    }

    @Transactional
    public void save(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.dtoToCategory(categoryDto);
        categoryRepository.save(category);
    }

    @Transactional
    public void update(CategoryDto categoryDto) {
        Long id = categoryDto.getId();
        categoryRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        Category category = CategoryMapper.INSTANCE.dtoToCategory(categoryDto);
        category.setId(id);
        categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.findById(id).orElseThrow(() -> new CustomException(NOT_FOUND));
        categoryRepository.deleteById(id);
    }
}
