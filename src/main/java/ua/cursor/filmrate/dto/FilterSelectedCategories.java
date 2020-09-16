package ua.cursor.filmrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterSelectedCategories {

    List<CategoryBaseDTO> categories;
}
