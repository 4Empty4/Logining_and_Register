package com.example.aplication_loger.Controller;

import com.example.aplication_loger.Service.LoginService;
import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    User user;
    @Autowired
    LoginService loginService;


    UserRepository user_repository;

    public LoginController(UserRepository user_repository) {
        this.user_repository = user_repository;
    }

    @GetMapping("/Login")
    public String login(Model model) {
        model.addAttribute("log_user", new User());
        return "Login";
    }

    @PostMapping("/chek")
    public String chek_log(@ModelAttribute User user)  {
        return loginService.LoginCheck(user);
    }




}