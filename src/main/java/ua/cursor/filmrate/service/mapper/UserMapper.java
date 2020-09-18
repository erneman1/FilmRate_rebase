package ua.cursor.filmrate.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import ua.cursor.filmrate.dto.UserDTO;
import ua.cursor.filmrate.dto.base.UserBaseDTO;
import ua.cursor.filmrate.entity.User;

@Mapper
public interface UserMapper {

    UserBaseDTO toUserBaseDTO(User user);

    UserDTO toUserDTO(User user);

    @ValueMapping(source = "ROLE_ADMIN", target = "ROLE_ADMIN")
    @ValueMapping(source = "ROLE_USER", target = "ROLE_USER")
    User toUserEntityFromBaseDTO(UserBaseDTO userBaseDTO);

    User toUserEntityFromDTO(UserDTO userDTO);
}
