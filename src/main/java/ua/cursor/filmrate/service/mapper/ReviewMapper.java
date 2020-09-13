package ua.cursor.filmrate.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.cursor.filmrate.dto.ReviewDTO;
import ua.cursor.filmrate.entity.Review;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReviewMapper {

    Review toReviewEntityFromDTO(ReviewDTO reviewDTO);

    ReviewDTO toReviewDTO(Review review);
}
