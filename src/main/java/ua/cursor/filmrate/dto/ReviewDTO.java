package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReviewDTO {
    private Long id;
    @NonNull
    private MovieDTO movie;
    @NonNull
    private String message;
    @NonNull
    private Boolean liked;
}
