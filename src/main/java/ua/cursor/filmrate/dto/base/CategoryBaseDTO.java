package ua.cursor.filmrate.dto.base;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@ToString
public class CategoryBaseDTO {
    private Long id;
    @NonNull
    private String name;
}