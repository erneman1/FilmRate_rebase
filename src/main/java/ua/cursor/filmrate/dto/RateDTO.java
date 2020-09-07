package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class RateDTO {
    private Long id;
    @NonNull
    private Long votesCount;
    @NonNull
    private Double rateValue;
}
