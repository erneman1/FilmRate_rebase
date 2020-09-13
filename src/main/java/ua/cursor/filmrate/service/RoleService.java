package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.entity.Role;
import ua.cursor.filmrate.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void createRoles() {
        Role roleAdmin = new Role();
        Role roleUser = new Role();
        Role roleManager = new Role();
        roleAdmin.setName("ADMIN");
        roleUser.setName("USER");
        roleManager.setName("MANAGER");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        roleRepository.save(roleManager);
    }

    public Set<Role> findAll() {
        return Set.copyOf(roleRepository.findAll());
    }
}
