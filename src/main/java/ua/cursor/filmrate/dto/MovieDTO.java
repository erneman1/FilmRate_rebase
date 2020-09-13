package ua.cursor.filmrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO extends MovieBaseDTO {
    private List<ReviewDTO> reviews = new ArrayList<>();
}
