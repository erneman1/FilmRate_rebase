package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.service.MovieService;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping("/all")
    public String getAllMoviesByFilter(Model model, @RequestParam(required = false, defaultValue = "asc", value = "orderBy") String orderBy) {
        System.out.println(orderBy);
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("comparator", Comparator.comparing(Movie::getRateValue).reversed());
        return "home";
    }

    @GetMapping("/add")
    public String addMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }

    @PostMapping("/save")
    public String saveMovie(Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movie/all";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("movieId") long id){
        movieService.deleteMovie(id);
        return "redirect:/movie/all";
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
