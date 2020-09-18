package ua.cursor.filmrate.dto;

import lombok.*;
import ua.cursor.filmrate.dto.base.UserBaseDTO;
import ua.cursor.filmrate.entity.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDTO extends UserBaseDTO {
    Role role;
}
