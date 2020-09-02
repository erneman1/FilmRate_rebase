package ua.cursor.movieplatform.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.cursor.movieplatform.dto.UserDTO;
import ua.cursor.movieplatform.dto.base.UserBaseDTO;
import ua.cursor.movieplatform.entity.User;

@Mapper(uses = RoleMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserBaseDTO toUserBaseDTO(User user);

    UserDTO toUserDTO(User user);

    @Mapping(target = "userRoles", ignore = true)
    User toUserEntityFromBaseDTO(UserBaseDTO userBaseDTO);

    User toUserEntityFromDTO(UserDTO userDTO);
}
