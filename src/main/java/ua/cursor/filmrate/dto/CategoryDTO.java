package ua.cursor.filmrate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ua.cursor.filmrate.dto.base.CategoryBaseDTO;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
public class CategoryDTO extends CategoryBaseDTO {
    @JsonIgnore
    private Set<MovieDTO> movies = new HashSet<>();
}