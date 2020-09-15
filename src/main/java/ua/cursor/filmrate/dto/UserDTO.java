package ua.cursor.filmrate.dto;

import lombok.*;
import ua.cursor.filmrate.dto.base.UserBaseDTO;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDTO extends UserBaseDTO {
    private Set<RoleDTO> userRoles = new HashSet<>();
}
