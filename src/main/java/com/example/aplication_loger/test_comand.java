package com.example.aplication_loger;

import org.springframework.ui.*;
import jakarta.persistence.OneToOne;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Controller
public class test_comand {
 /*  User_Repo userRepo;
  User user;

   public test_comand(User_Repo userRepo) {
       this.userRepo = userRepo;
    }

    @GetMapping("/index")
    public String test(Model model){
        User user1 = new User("Oleksi","Empty","123@gmail.com","1678",677832);
        User user2 = new User("Nazar","Lys","ls@gmail.com","1111",819371);
        User user3 = new User("Vlad","Enot","eno@gmail.com","3334",123047);
        User user4 = new User("Serhi","Leo","serh@gmail.com","5552",321034);

        List<User> users = Arrays.asList(user1, user2, user3, user4);


       // model.addAttribute("users" , users);
        model.addAttribute("newUser",new User());


        return "index";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user){
        System.out.println(user);
        return "redirect:/index";
    }
*/

    User_Repo user_repo;

    User user_test;

    AESEncryptionDecryption aes;


    public test_comand(User_Repo user_repo) {
        this.user_repo = user_repo;

    }



@GetMapping("/test")
    String test(){

        aes.main("Jumani");

        return "work";
}




}
