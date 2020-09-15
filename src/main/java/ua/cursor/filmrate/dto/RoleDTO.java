package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class RoleDTO {
    private Long id;
    @NonNull
    private String name;
}
