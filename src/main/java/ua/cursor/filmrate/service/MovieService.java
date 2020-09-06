package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.repository.MovieRepository;
import ua.cursor.filmrate.service.mapper.MovieMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    public List<MovieBaseDTO> getAllMovies(){
        return mapper.toMovieBaseDTOs(repository.findAll());
    }

    public List<MovieBaseDTO> getAllMoviesSortedByRating(){
        return mapper.toMovieBaseDTOs(
                repository.findAll().stream()
                        .sorted(Comparator.comparing(Movie::getRateValue).reversed())
                        .collect(Collectors.toList())
        );
    }

    public MovieDTO getMovieById(long id){
        return mapper.toMovieDTO(repository.getById(id));
    }

    public void saveMovie(Movie movie){
        repository.save(movie);
    }

    public void deleteMovie(long id){
        repository.deleteById(id);
    }

}

