package ua.cursor.filmrate.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.cursor.filmrate.dto.ReviewDTO;
import ua.cursor.filmrate.entity.Review;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewMapper {

    @Mapping(target = "movie", ignore = true)
    Review toReviewEntityFromDTO(ReviewDTO reviewDTO);

    @Mapping(target = "movie", ignore = true)
    ReviewDTO toReviewDTO(Review review);
}
