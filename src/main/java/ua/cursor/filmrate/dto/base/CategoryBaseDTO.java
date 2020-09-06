package ua.cursor.filmrate.dto.base;

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