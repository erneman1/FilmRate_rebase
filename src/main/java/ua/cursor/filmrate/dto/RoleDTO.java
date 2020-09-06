package ua.cursor.filmrate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class RoleDTO {
    private Long id;
    @NonNull
    private String name;
}
