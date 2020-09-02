package ua.cursor.movieplatform.service;

import org.springframework.stereotype.Service;
import ua.cursor.movieplatform.dto.RoleDTO;
import ua.cursor.movieplatform.repository.RoleRepository;
import ua.cursor.movieplatform.service.mapper.RoleMapper;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @PostConstruct
    public void createRoles() {
        RoleDTO roleAdmin = new RoleDTO("ADMIN");
        RoleDTO roleUser = new RoleDTO("USER");
        RoleDTO roleManager = new RoleDTO("MANAGER");
        roleRepository.save(roleMapper.toRoleEntity(roleAdmin));
        roleRepository.save(roleMapper.toRoleEntity(roleUser));
        roleRepository.save(roleMapper.toRoleEntity(roleManager));
    }

    public Set<RoleDTO> findAll() {
        return roleMapper.toRoleDTOsFromRole(Set.copyOf(roleRepository.findAll()));
    }
}
