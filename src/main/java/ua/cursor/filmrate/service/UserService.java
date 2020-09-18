package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.dto.UserDTO;
import ua.cursor.filmrate.entity.User;
import ua.cursor.filmrate.entity.enums.Role;
import ua.cursor.filmrate.repository.UserRepository;
import ua.cursor.filmrate.security.UserDetailsServiceImpl;
import ua.cursor.filmrate.service.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailsServiceImpl userDetailsService;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void registerUser(UserDTO userDTO) {
        if (isUserExists(userDTO.getLogin())) {
            throw new RuntimeException("User is already exists");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userDTO.setRole(Role.ROLE_USER);
        User user = userMapper.toUserEntityFromDTO(userDTO);
        save(user);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), user.getRole().getAuthorities());
        userDetailsService..authenticate(token);
    }

    public boolean isUserExists(String login) {
        return userRepository.findByLogin(login) != null;
    }
}
