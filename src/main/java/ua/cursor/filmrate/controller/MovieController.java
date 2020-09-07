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
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public String getAllMoviesByFilter(Model model, @RequestParam(required = false, defaultValue = "asc", value = "orderBy") String orderBy) {
        System.out.println(orderBy);
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("comparator", Comparator.comparing((Movie movie) -> movie.getRate().getRateValue()).reversed());
        return "home";
    }

    @PostMapping
    public String saveMovie(Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@RequestParam("id") long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/{id}/rate/{rate}")
    public String addRate(Model model, @PathVariable("id") Long id, @PathVariable("rate") Double rate) {
        movieService.addRate(rate, id);
        return "redirect:/movies";
    }

    @GetMapping("/rating")
    public List<MovieBaseDTO> getAllSortedByRate() {
        return movieService.getAllMoviesSortedByRating();
    }

}
