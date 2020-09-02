package ua.cursor.movieplatform.dto.base;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryBaseDTO {
    private Long id;
    @NonNull
    private String name;
}