package ua.cursor.filmrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO extends CategoryBaseDTO {
    private Set<MovieDTO> movies;
}