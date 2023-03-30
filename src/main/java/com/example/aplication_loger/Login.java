package com.example.aplication_loger;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class Login {
    User user;
    User_Repo user_repo;

    public Login(User_Repo user_repo) {
        this.user_repo = user_repo;
    }

    @GetMapping("/Login")
    public String login(Model model) {
        model.addAttribute("log_user", new User());
        return "Login";
    }

    @PostMapping("/chek")
    public String chek_log(@ModelAttribute User user)  {
        System.out.println("Inf about User: " + user);
        boolean test =  user_repo.existsByEmailAndLogin(user.getEmail(), user.getLogin());
        System.out.println(test);
        if (test){


            System.out.println(test);
            return "redirect:/index";

        }else {
            System.out.println(test);
            return "redirect:/Login";
        }
    }




}