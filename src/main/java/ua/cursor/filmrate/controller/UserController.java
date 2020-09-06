package ua.cursor.movieplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.cursor.movieplatform.entity.User;
import ua.cursor.movieplatform.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String getUser(Model model){
        model.addAttribute("usr", service.getBaseUserDTOById(1).getName());
        return "home";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration/save")
    public String addUser(User user){
        service.save(user);
        return "redirect:/";
    }

}
