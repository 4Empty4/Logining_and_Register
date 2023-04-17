package com.example.aplication_loger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Controller
public class Register {

    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    User_Repo user_repo;
    User user;

    final String secretKey = "secrete";

    AESEncryptionDecryption aes;

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



        user.setPassword(aesEncryptionDecryption.encrypt(user.getPassword(), secretKey));
        boolean cheker=user_repo.existsByEmailOrLogin(user.getEmail(),user.getLogin());
        if (cheker) {
            System.out.println(cheker);
            return "redirect:Register";

        }else {

            System.out.println(user.getPassword());


            user_repo.save(user);
            return "redirect:index";
        }
    }



}
