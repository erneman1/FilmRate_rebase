package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cursor.filmrate.dto.FilterSelectedCategories;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.ReviewDTO;
import ua.cursor.filmrate.entity.RateValue;
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

    @PostMapping("/{movieId}/add-review")
    public String addReview(@PathVariable("movieId") long movieId, @ModelAttribute("newRate") RateValue rateValue, ReviewDTO reviewDTO, Model model) {
        model.addAttribute("newRate", new RateValue());
        System.out.println("\n\n\n" + reviewDTO.toString() + "\n\n\n");
        if(!reviewDTO.getMessage().isEmpty()){
            movieService.addReview(movieId, reviewMapper.toReviewEntityFromDTO(reviewDTO));
        }
        if (rateValue != null) {
            movieService.addRate(movieId, rateValue.getValue());
        }


        return "redirect:/movies/" + movieId;
    }

    @GetMapping("/{movieId}/add-review")
    public String getReviewForm(@PathVariable long movieId, Model model) {
        model.addAttribute("review", new ReviewDTO());
        model.addAttribute("newRate", new RateValue());
        model.addAttribute("movie_id", movieId);
        return "review_form";
    }

    @PostMapping("/category")
    public String getAllInCategory(@ModelAttribute("filtered") FilterSelectedCategories filterSelectedCategories, Model model) {
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

    @PostMapping("/like")
    public void like(@ModelAttribute ReviewDTO reviewDTO){
        reviewDTO.setLiked(true);
    }
}
