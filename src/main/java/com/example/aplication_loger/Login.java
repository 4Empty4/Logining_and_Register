package com.example.aplication_loger;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class Login {
    User user;

    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    final String secretKey = "secrete";

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

        user.setPassword(aesEncryptionDecryption.encrypt(user.getPassword(), secretKey));

        System.out.println("Inf about User: " + user);

        boolean test =  user_repo.existsByEmailAndLoginAndPassword(user.getEmail(), user.getLogin(), user.getPassword());

        System.out.println(test);
        if (test){

            return "redirect:/inf_about_user";

        }else {
            System.out.println(test);
            return "redirect:/Login";
        }
    }




}