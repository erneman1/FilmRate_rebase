package ua.cursor.movieplatform.service.mapper;

import org.mapstruct.*;
import ua.cursor.movieplatform.dto.CategoryDTO;
import ua.cursor.movieplatform.dto.MovieDTO;
import ua.cursor.movieplatform.dto.ReviewDTO;
import ua.cursor.movieplatform.dto.base.MovieBaseDTO;
import ua.cursor.movieplatform.entity.Category;
import ua.cursor.movieplatform.entity.Movie;
import ua.cursor.movieplatform.entity.Review;

@Mapper(uses = {CategoryMapper.class, ReviewMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MovieMapper {

    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "categories", ignore = true)
    MovieDTO toMovieDTO(Movie movie);

    MovieBaseDTO toMovieBaseDTO(Movie movie);

    @AfterMapping
    default void toMovieDTOMapping(@MappingTarget MovieDTO movieDTO) {
        if (movieDTO.getReviews() != null) {
            for (ReviewDTO reviewDTO : movieDTO.getReviews()) {
                reviewDTO.setMovie(movieDTO);
            }
        }
        if (movieDTO.getCategories() != null) {
            for (CategoryDTO categoryDTO : movieDTO.getCategories()) {
                categoryDTO.getMovies().add(movieDTO);
            }
        }
    }

    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Movie toMovieEntityFromBaseDTO(MovieBaseDTO movieBaseDTO);

    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Movie toMovieEntityFromDTO(MovieDTO movieDTO);

    @AfterMapping
    default void toMovieMapping(@MappingTarget Movie movie) {
        if (movie.getReviews() != null) {
            for (Review review : movie.getReviews()) {
                review.setMovie(movie);
            }
        }
        if (movie.getCategories() != null) {
            for (Category category : movie.getCategories()) {
                category.getMovies().add(movie);
            }
        }
    }

}
