package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cursor.filmrate.dto.FilterSelectedCategories;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.ReviewDTO;
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.MovieService;
import ua.cursor.filmrate.service.mapper.CategoryMapper;
import ua.cursor.filmrate.service.mapper.MovieMapper;
import ua.cursor.filmrate.service.mapper.ReviewMapper;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @GetMapping
    public String getAllMoviesByFilter(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("filtered", new FilterSelectedCategories());
        return "home";
    }

    @GetMapping("/sorted")
    public String getAllMoviesSortedByRating(Model model) {
        model.addAttribute("movies", movieMapper.toMovieBaseDTOs(movieService.getAllMoviesSortedByRating()));
        return "sorted";
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable(value = "id") long id, Model model) {
        MovieDTO movieDTO = movieMapper.toMovieDTO(movieService.getMovieByIdWithReviews(id));
        model.addAttribute("movie", movieDTO);
        model.addAttribute("categories", movieDTO.getCategories());
        model.addAttribute("reviews", movieDTO.getReviews());
        return "details";
    }

//    @GetMapping("/{id}/rate/{rate}")
//    public String addRate(@PathVariable("id") Long id, @PathVariable("rate") Double rate) {
//        movieService.addRate(id, rate);
//        return "redirect:/movies";
//    }

    @PostMapping("/{movieId}/{rate}/add-review")
    public String addReview(@PathVariable("movieId") long movieId, @PathVariable("rate") double rate, ReviewDTO reviewDTO) {
        System.out.println(reviewDTO.toString());
        if (!reviewDTO.getMessage().isEmpty()){
            movieService.addReview(movieId, reviewMapper.toReviewEntityFromDTO(reviewDTO));
        }
        movieService.addRate(movieId, rate);
        return "redirect:/movies/" + movieId;
    }

    @GetMapping("/{movieId}/add-review")
    public String getReviewForm(@PathVariable long movieId, Model model) {
        model.addAttribute("review", new ReviewDTO());
        model.addAttribute("movie", movieService.getMovieByIdWithReviews(movieId));
        model.addAttribute("movie_id", movieId);
        return "review_form";
    }

    @PostMapping("/category")
    public String getAllInCategory(@ModelAttribute("filtered") FilterSelectedCategories filterSelectedCategories, Model model) {
        System.out.println("\n\n\n\n\n\n" + filterSelectedCategories.toString() + "\n\n\n\n\n\n");
        model.addAttribute("movies",
                movieService.getAllByCategoriesContains(
                        categoryMapper
                                .toCategoryEntitiesFromBaseDTOs(
                                        filterSelectedCategories
                                                .getCategories()))

        );
        model.addAttribute("categories", categoryMapper.toCategoryBaseDTOs(categoryService.getAll()));
        model.addAttribute("filtered", filterSelectedCategories);
        return "filter";

    }
}
