package ua.cursor.filmrate.entity;


import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;
import ua.cursor.filmrate.service.CategoryService;
import ua.cursor.filmrate.service.mapper.CategoryMapper;

import java.util.List;
import java.util.stream.Collectors;

//@Component
//@RequiredArgsConstructor
public class MovieConverter {
//
//    private final CategoryService categoryService;
//    private final CategoryMapper categoryMapper;
//
//    @Override
//    public CategoryBaseDTO convert(String id) {
//
//        List<CategoryBaseDTO> list = categoryService.getAll().stream()
//                .map(categoryMapper::toCategoryBaseDTO)
//                .collect(Collectors.toList());
//        return list.get(Integer.parseInt(id) - 1);
//    }
}
