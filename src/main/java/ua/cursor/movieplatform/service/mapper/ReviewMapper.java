package ua.cursor.movieplatform.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.cursor.movieplatform.dto.ReviewDTO;
import ua.cursor.movieplatform.entity.Review;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewMapper {

    @Mapping(target = "movie", ignore = true)
    Review toReviewEntityFromDTO(ReviewDTO reviewDTO);

    @Mapping(target = "movie", ignore = true)
    ReviewDTO toReviewDTO(Review review);
}
