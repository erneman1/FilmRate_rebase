package ua.cursor.filmrate.dto.base;

import lombok.*;
import ua.cursor.filmrate.dto.RateDTO;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class MovieBaseDTO {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String director;

    @NonNull
    private String description;

    private RateDTO rate;

    private Set<CategoryBaseDTO> categories = new HashSet<>();
}
