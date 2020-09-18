package ua.cursor.filmrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.cursor.filmrate.dto.UserDTO;
import ua.cursor.filmrate.service.UserService;
import ua.cursor.filmrate.service.mapper.UserMapper;

@Controller
@RequestMapping("/")
public class LoginController {

    private final UserService userService;
    private final UserMapper userMapper;

    public LoginController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "loginPage";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("newUserDTO", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute UserDTO userDTO) {
        userService.registerUser(userDTO);
        return "redirect:/login";
    }
}
