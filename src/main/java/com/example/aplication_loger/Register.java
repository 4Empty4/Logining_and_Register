package com.example.aplication_loger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.*;

@Controller
public class Register {

    User_Repo user_repo;
    User user;

    public Register(User_Repo user_repo) {
        this.user_repo = user_repo;
    }

    @GetMapping("/Register")
    public String getInf(Model model){
        model.addAttribute("newUser", new User());
        return "Register";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user)  {
        System.out.println("Inf about User: " + user);

        boolean cheker=user_repo.existsByEmailOrLoginOrName(user.getEmail(),user.getLogin(),user.getName());
        if (cheker) {

            System.out.println(cheker);
            return "redirect:Register";

        }else {

            user_repo.save(user);
            return "redirect:index";
        }
    }



}
