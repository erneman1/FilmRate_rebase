package ua.cursor.filmrate.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.mapper.CategoryMapper;

@Component
@RequiredArgsConstructor
public class CategoryConverter implements Converter<String, CategoryBaseDTO> {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryBaseDTO convert(String id) {
        return categoryMapper.toCategoryBaseDTO(
                categoryService.getById(Long.parseLong(id))
        );
    }
}
