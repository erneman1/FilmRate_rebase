package ua.cursor.movieplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


}
