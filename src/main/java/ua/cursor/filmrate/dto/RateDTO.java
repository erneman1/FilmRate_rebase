package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class RateDTO {
    private Long id;
    @NonNull
    private Long votesCount;
    @NonNull
    private Double rateValue;
}
