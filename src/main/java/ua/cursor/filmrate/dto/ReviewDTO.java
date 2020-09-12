package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString(of = {"id", "message", "liked"})
public class ReviewDTO {
    private Long id;
    @NonNull
    private MovieDTO movie;
    @NonNull
    private String message;
    @NonNull
    private Boolean liked;
}
