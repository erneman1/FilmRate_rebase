package ua.cursor.movieplatform.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.cursor.movieplatform.dto.RoleDTO;
import ua.cursor.movieplatform.entity.Role;

import java.util.Set;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleMapper {

    RoleDTO toRoleDTO(Role role);

    Role toRoleEntity(RoleDTO roleDTO);

    Set<Role> toRoleEntitiesFromRoleDTO(Set<RoleDTO> roleDTOs);

    Set<RoleDTO> toRoleDTOsFromRole(Set<Role> roles);
}
