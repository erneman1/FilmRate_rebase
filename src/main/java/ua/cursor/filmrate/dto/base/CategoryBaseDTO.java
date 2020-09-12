package ua.cursor.filmrate.dto.base;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"id", "name"}, callSuper = false)
@ToString(of = {"id", "name"})
public class CategoryBaseDTO {
    private Long id;
    @NonNull
    private String name;
}