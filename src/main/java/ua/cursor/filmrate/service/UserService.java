package ua.cursor.filmrate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.cursor.filmrate.dto.RoleDTO;
import ua.cursor.filmrate.dto.UserDTO;
import ua.cursor.filmrate.dto.base.UserBaseDTO;
import ua.cursor.filmrate.entity.User;
import ua.cursor.filmrate.repository.UserRepository;
import ua.cursor.filmrate.service.mapper.UserMapper;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, UserMapper userMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @PostConstruct
    @Transactional
    public void createUsers() {
        Set<RoleDTO> roles = roleService.findAll();

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test");
        userDTO.setPassword("");
        userDTO.setUserRoles(roles);

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setName("Test1");
        userDTO1.setPassword("");
        userDTO1.setUserRoles(roles);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Test2");
        userDTO2.setPassword("");
        userDTO2.setUserRoles(roles);

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Test3");
        userDTO3.setPassword("");
        userDTO3.setUserRoles(roles);

        userRepository.save(userMapper.toUserEntityFromDTO(userDTO));
        userRepository.save(userMapper.toUserEntityFromDTO(userDTO1));
        userRepository.save(userMapper.toUserEntityFromDTO(userDTO2));
        userRepository.save(userMapper.toUserEntityFromDTO(userDTO3));

        userRepository.findAllWithRoles().forEach(System.out::println);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public UserBaseDTO getBaseUserDTOById(long id){
        return userMapper.toUserBaseDTO(userRepository.findById(id));
    }

    public UserDTO getUserDTOById(long id){
        return userMapper.toUserDTO(userRepository.findById(id));
    }
}
