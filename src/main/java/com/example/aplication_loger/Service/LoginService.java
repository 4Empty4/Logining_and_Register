package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;

import com.example.aplication_loger.Repository.UserRepository;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;



@RestController
@Service
public class LoginService {


    private final UserRepository user_Repository;
    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    final String secretKey = "secrete";

    public LoginService(UserRepository user_Repository) {
        this.user_Repository = user_Repository;
    }

    public String LoginCheck(User user){

        System.out.println("User password: " + user.getPassword());



        System.out.println("User password after encrypt: " + user.getPassword());



        if (user_Repository.existsByEmailAndLoginAndPassword(user.getEmail(), user.getPassword(), user.getPassword())){
            System.out.println("Login Success");
            return "redirect:/information";
        }else{
            return "redirect:/Login";
        }


    }


}
