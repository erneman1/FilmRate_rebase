package ua.cursor.filmrate.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.cursor.filmrate.dto.CategoryDTO;
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.mapper.CategoryMapper;

@Component
@RequiredArgsConstructor
public class CategoryConverter implements Converter<String, CategoryDTO> {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO convert(String id) {
        return categoryMapper.toCategoryDTO(
                categoryService.getById(Long.parseLong(id))
        );
    }
}
