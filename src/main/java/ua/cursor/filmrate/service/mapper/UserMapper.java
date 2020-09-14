package ua.cursor.filmrate.service.mapper;

import ua.cursor.filmrate.dto.UserDTO;
import ua.cursor.filmrate.dto.base.UserBaseDTO;
import ua.cursor.filmrate.entity.User;

public interface UserMapper {

    UserBaseDTO toUserBaseDTO(User user);

    UserDTO toUserDTO(User user);

    User toUserEntityFromBaseDTO(UserBaseDTO userBaseDTO);

    User toUserEntityFromDTO(UserDTO userDTO);
}
