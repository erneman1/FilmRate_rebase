package ua.cursor.movieplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.cursor.movieplatform.dto.base.MovieBaseDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO extends MovieBaseDTO {
    private Set<CategoryDTO> categories = new HashSet<>();
    private List<ReviewDTO> reviews = new ArrayList<>();

}
