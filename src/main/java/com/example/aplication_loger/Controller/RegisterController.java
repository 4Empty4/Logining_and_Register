package com.example.aplication_loger.Controller;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import com.example.aplication_loger.Service.AESEncryptionDecryption;
import com.example.aplication_loger.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    @Autowired
    UserRepository userRepository;
    User user;
    @Autowired
    public RegisterService registerService;

    final String secretKey = "secrete";

    AESEncryptionDecryption aes;


    @GetMapping("/Register")
    public String getInf(Model model){
        model.addAttribute("newUser", new User());
        return "Register";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user)  {
        return registerService.registerUser(user);
    }



}
