package ua.cursor.filmrate.service.mapper;

import org.mapstruct.*;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.entity.Movie;

import java.util.List;

@Mapper(uses = {CategoryMapper.class, ReviewMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MovieMapper {

    MovieDTO toMovieDTO(Movie movie);

    @Mapping(target = "categories", ignore = true)
    @Named(value = "toMovieBaseDTO")
    MovieBaseDTO toMovieBaseDTO(Movie movie);

    @IterableMapping(qualifiedByName = "toMovieBaseDTO")
    List<MovieBaseDTO> toMovieBaseDTOs(List<Movie> movies);

    @Mapping(target = "reviews", ignore = true)
    Movie toMovieEntityFromBaseDTO(MovieBaseDTO movieBaseDTO);

    @Mapping(target = "reviews", ignore = true)
    Movie toMovieEntityFromDTO(MovieDTO movieDTO);
}
