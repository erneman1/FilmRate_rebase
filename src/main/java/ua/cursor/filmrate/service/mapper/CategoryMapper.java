package ua.cursor.filmrate.service.mapper;

import org.mapstruct.*;
import ua.cursor.filmrate.dto.CategoryDTO;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;

@Mapper(uses = MovieMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    @Mapping(target = "movies", ignore = true)
    CategoryDTO toCategoryDTO(Category category);

    CategoryBaseDTO toCategoryBaseDTO(Category category);

    @AfterMapping
    default void toCategoryDTOMapping(@MappingTarget CategoryDTO categoryDTO) {
        if (categoryDTO.getMovies() != null) {
            for (MovieDTO movieDTO : categoryDTO.getMovies()) {
                movieDTO.getCategories().add(categoryDTO);
            }
        }
    }

    @Mapping(target = "movies", ignore = true)
    Category toCategoryEntityFromBaseDTO(CategoryBaseDTO categoryBaseDTO);

    @Mapping(target = "movies", ignore = true)
    Category toCategoryEntityFromDTO(CategoryDTO categoryDTO);

    @AfterMapping
    default void toCategoryMapping(@MappingTarget Category category) {
        if (category.getMovies() != null) {
            for (Movie movie : category.getMovies()) {
                movie.getCategories().add(category);
            }
        }
    }
}
