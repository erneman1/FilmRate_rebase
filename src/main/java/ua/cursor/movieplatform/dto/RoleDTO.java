package ua.cursor.movieplatform.dto;

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
