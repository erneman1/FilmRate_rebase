package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.ReviewDTO;
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

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable long id) {
        System.out.println(id);
        movieService.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }

    @GetMapping("/{id}/rate/{rate}")
    public String addRate(@PathVariable("id") Long id, @PathVariable("rate") Double rate) {
        movieService.addRate(id, rate);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/add-review")
    public String addReview(@PathVariable long id, Model model) {
        model.addAttribute("review", new ReviewDTO());
        model.addAttribute("movie_id", id);
        return "review_form";
    }

    @PostMapping("/{movieId}/add-review")
    public String saveReview(@PathVariable("movieId") Long movieId, ReviewDTO reviewDTO) {
        movieService.saveReview(movieId, reviewDTO);
        return "redirect:/movies/" + movieId;
    }

    @GetMapping("/rating")
    public List<MovieBaseDTO> getAllSortedByRate() {
        return movieService.getAllMoviesSortedByRating();
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable(value = "id") long id, Model model) {
        MovieDTO movieDTO = (movieService.getMovieByIdWithReviews(id));
        model.addAttribute("movie", movieDTO);
        model.addAttribute("categories", movieDTO.getCategories());
        model.addAttribute("reviews", movieDTO.getReviews());

        return "details";
    }

}
