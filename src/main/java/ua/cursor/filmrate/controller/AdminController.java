package ua.cursor.filmrate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.MovieService;
import ua.cursor.filmrate.service.mapper.CategoryMapper;
import ua.cursor.filmrate.service.mapper.MovieMapper;
import ua.cursor.filmrate.service.mapper.ReviewMapper;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/movies")
@RequiredArgsConstructor
public class AdminController {
    private final MovieService movieService;
    private final CategoryService categoryService;

    private final MovieMapper movieMapper;
    private final CategoryMapper categoryMapper;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public String saveMovie(@ModelAttribute("movieDTO") MovieDTO movieDTO) {
        movieService.save(movieMapper.toMovieEntityFromDTO(movieDTO));
        return "redirect:/movies";
    }

    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable("id") long id, MovieDTO movieDTO) {
        movieService.save(movieMapper.toMovieEntityFromDTO(movieDTO));
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable long id) {
        System.out.println(id);
        movieService.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/add")
    public String getAddMovieForm(Model model) {
        model.addAttribute("movie", new MovieDTO());
        model.addAttribute("categoriesAll",
                categoryService.getAll()
                        .stream()
                        .map(categoryMapper::toCategoryDTO)
                        .collect(Collectors.toList()));
        return "add_movie";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateMovieForm(@PathVariable("id") long id,  Model model) {
        model.addAttribute("movie", movieMapper.toMovieDTO(movieService.getMovieByIdWithReviews(id)));
        model.addAttribute("categoriesAll",
                categoryService.getAll()
                        .stream()
                        .map(categoryMapper::toCategoryDTO)
                        .collect(Collectors.toList()));
        return "update_movie";
    }
}
