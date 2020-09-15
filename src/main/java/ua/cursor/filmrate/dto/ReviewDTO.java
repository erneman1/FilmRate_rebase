package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class ReviewDTO {
    private Long id;
    @NonNull
    private String message;
    @NonNull
    private Boolean liked;
}
