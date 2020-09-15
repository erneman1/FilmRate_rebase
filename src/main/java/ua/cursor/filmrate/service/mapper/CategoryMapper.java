package ua.cursor.filmrate.service.mapper;

import org.mapstruct.*;
import ua.cursor.filmrate.dto.CategoryDTO;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;
import ua.cursor.filmrate.entity.Category;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    @Named(value = "toCategoryDTO")
    CategoryDTO toCategoryDTO(Category category);

    @Named(value = "toCategoryBaseDTO")
    CategoryBaseDTO toCategoryBaseDTO(Category category);

    @Mapping(target = "movies", ignore = true)
    Category toCategoryEntityFromBaseDTO(CategoryBaseDTO categoryBaseDTO);

    @Mapping(target = "movies", ignore = true)
    Category toCategoryEntityFromDTO(CategoryDTO categoryDTO);

    @IterableMapping(qualifiedByName = "toCategoryDTO")
    List<CategoryDTO> toCategoryDTOs(List<Category> categories);

    @IterableMapping(qualifiedByName = "toCategoryBaseDTO")
    List<CategoryBaseDTO> toCategoryBaseDTOs(List<Category> categories);
}
