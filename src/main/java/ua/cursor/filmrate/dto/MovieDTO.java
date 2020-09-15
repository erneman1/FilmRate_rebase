package ua.cursor.filmrate.dto;

import lombok.*;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class MovieDTO extends MovieBaseDTO {

    private List<ReviewDTO> reviews = new ArrayList<>();
}
