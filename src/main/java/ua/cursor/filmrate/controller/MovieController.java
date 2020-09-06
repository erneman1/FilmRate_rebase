package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.service.MovieService;

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
