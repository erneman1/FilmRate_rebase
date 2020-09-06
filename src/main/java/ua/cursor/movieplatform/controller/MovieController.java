package ua.cursor.movieplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.cursor.movieplatform.dto.MovieDTO;
import ua.cursor.movieplatform.dto.base.MovieBaseDTO;
import ua.cursor.movieplatform.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public List<MovieBaseDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/rating")
    public List<MovieBaseDTO> getAllSortedByRate() {
        return movieService.getAllMoviesSortedByRating();
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable long id){
        return movieService.getMovieById(id);
    }

}
