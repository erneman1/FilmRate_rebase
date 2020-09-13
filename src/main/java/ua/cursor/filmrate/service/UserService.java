package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.cursor.filmrate.entity.Role;
import ua.cursor.filmrate.entity.User;
import ua.cursor.filmrate.repository.UserRepository;
import ua.cursor.filmrate.service.mapper.UserMapper;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;


    //    @PostConstruct
    @Transactional
    public void createUsers() {
        Set<Role> roles = roleService.findAll();

        User user = new User();
        user.setName("Test");
        user.setPassword("");
        user.setUserRoles(roles);

        User user1 = new User();
        user1.setName("Test1");
        user1.setPassword("");
        user1.setUserRoles(roles);

        User user2 = new User();
        user2.setName("Test2");
        user2.setPassword("");
        user2.setUserRoles(roles);

        User user3 = new User();
        user3.setName("Test3");
        user3.setPassword("");
        user3.setUserRoles(roles);

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        userRepository.findAllWithRoles().forEach(System.out::println);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getBaseUserDTOById(long id) {
        return userRepository.findById(id);
    }

    public User getUserById(long id) {
        return userRepository.findById(id);
    }
}
