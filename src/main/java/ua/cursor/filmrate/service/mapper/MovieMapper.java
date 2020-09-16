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
    @Mapping(target = "rate.rateValue", source = "movie.rate.rateValue", defaultValue = "0D")
    @Mapping(target = "rate.votesCount", source = "movie.rate.votesCount", defaultValue = "0L")
    MovieDTO toMovieDTO(Movie movie);


    @Named(value = "toMovieBaseDTO")
    @Mapping(target = "rate.rateValue", source = "movie.rate.rateValue", defaultValue = "0D")
    @Mapping(target = "rate.votesCount", source = "movie.rate.votesCount", defaultValue = "0L")
    @Mapping(target = "categories", ignore = true)
    MovieBaseDTO toMovieBaseDTO(Movie movie);

    @IterableMapping(qualifiedByName = "toMovieBaseDTO")
    List<MovieBaseDTO> toMovieBaseDTOs(List<Movie> movies);

    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "rate.rateValue", source = "movieBaseDTO.rate.rateValue", defaultValue = "0D")
    @Mapping(target = "rate.votesCount", source = "movieBaseDTO.rate.votesCount", defaultValue = "0L")
    Movie toMovieEntityFromBaseDTO(MovieBaseDTO movieBaseDTO);

    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "rate.rateValue", source = "movieDTO.rate.rateValue", defaultValue = "0D")
    @Mapping(target = "rate.votesCount", source = "movieDTO.rate.votesCount", defaultValue = "0L")
    Movie toMovieEntityFromDTO(MovieDTO movieDTO);
}
