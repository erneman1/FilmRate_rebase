package ua.cursor.movieplatform.dto.base;

import lombok.*;

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
}
