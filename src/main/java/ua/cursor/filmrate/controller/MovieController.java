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
import ua.cursor.filmrate.service.mapper.MovieMapper;
import ua.cursor.filmrate.service.mapper.ReviewMapper;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;

    @GetMapping
    public String getAllMoviesByFilter(Model model, @RequestParam(required = false, defaultValue = "asc", value = "orderBy") String orderBy) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("comparator", Comparator.comparing((Movie movie) -> movie.getRate().getRateValue()).reversed());
        return "home";
    }

    @GetMapping("/rating")
    public List<MovieBaseDTO> getAllSortedByRate() {
        return movieMapper.toMovieBaseDTOs(movieService.getAllMoviesSortedByRating());
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable(value = "id") long id, Model model) {
        MovieDTO movieDTO = movieMapper.toMovieDTO(movieService.getMovieByIdWithReviews(id));
        model.addAttribute("movie", movieDTO);
        model.addAttribute("categories", movieDTO.getCategories());
        model.addAttribute("reviews", movieDTO.getReviews());
        return "details";
    }

    @GetMapping("/{id}/rate/{rate}")
    public String addRate(@PathVariable("id") Long id, @PathVariable("rate") Double rate) {
        movieService.addRate(id, rate);
        return "redirect:/movies";
    }

    @PostMapping("/{movieId}/add-review")
    public String addReview(@PathVariable("movieId") Long movieId, ReviewDTO reviewDTO) {
        movieService.addReview(movieId, reviewMapper.toReviewEntityFromDTO(reviewDTO));
        return "redirect:/movies/" + movieId;
    }

    @GetMapping("/{movieId}/add-review")
    public String getReviewForm(@PathVariable long movieId, Model model) {
        model.addAttribute("review", new ReviewDTO());
        model.addAttribute("movie_id", movieId);
        return "review_form";
    }
}
