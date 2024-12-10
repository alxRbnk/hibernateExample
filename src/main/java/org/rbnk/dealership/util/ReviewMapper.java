package org.rbnk.dealership.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rbnk.dealership.dto.ReviewDto;
import org.rbnk.dealership.entity.Review;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDto reviewToDto(Review review);

    Review dtoToReview(ReviewDto dto);
}
