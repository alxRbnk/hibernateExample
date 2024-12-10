package org.rbnk.dealership.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rbnk.dealership.dto.CategoryDto;
import org.rbnk.dealership.entity.Category;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToDto(Category category);

    Category dtoToCategory(CategoryDto categoryDto);
}
