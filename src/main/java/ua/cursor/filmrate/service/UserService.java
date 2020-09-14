package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.entity.User;
import ua.cursor.filmrate.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }

    public User findByLogin(String login){
        User user = userRepository.findByLogin(login);
        System.out.println(user.getRole().getName());
        return user;

    }
}
