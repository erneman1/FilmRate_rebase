package ua.cursor.filmrate.service.mapper;

import org.mapstruct.*;
import ua.cursor.filmrate.dto.CategoryDTO;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;

import java.util.List;

@Mapper(uses = {CategoryMapper.class, ReviewMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MovieMapper {

//    @Mapping(target = "reviews", ignore = true)
//    @Mapping(target = "categories", ignore = true)
MovieDTO toMovieDTO(Movie movie);

    @Mapping(target = "categories", ignore = true)
    @Named(value = "useMe")
    MovieBaseDTO toMovieBaseDTO(Movie movie);

    @IterableMapping(qualifiedByName = "useMe")
    List<MovieBaseDTO> toMovieBaseDTOs(List<Movie> movies);

    @AfterMapping
    default void toMovieDTOMapping(@MappingTarget MovieDTO movieDTO) {
        System.out.println("FROM MAPPER " + movieDTO.getCategories().toString());
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
        if (movie.getCategories() != null) {
            for (Category category : movie.getCategories()) {
                category.getMovies().add(movie);
            }
        }
    }

}
