package ua.cursor.movieplatform.dto.base;

import lombok.*;
import ua.cursor.movieplatform.dto.CategoryDTO;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MovieBaseDTO {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String director;
    @NonNull
    private String description;
    private Double rateValue;
    private Set<CategoryDTO> categories = new HashSet<>();
}
