package ua.cursor.filmrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.cursor.filmrate.dto.base.UserBaseDTO;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserBaseDTO {
    private Set<RoleDTO> userRoles = new HashSet<>();
}
