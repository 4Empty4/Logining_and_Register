package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    final String secretKey = "secrete";
    @Autowired
    UserRepository userRepository;

    public String registerUser(User user) {

        user.setPassword(aesEncryptionDecryption.encrypt(user.getPassword(), secretKey));

        if(userRepository.existsByEmailOrLogin(user.getEmail(),user.getLogin())){
            System.out.println("Email already exists");
            return "redirect:Register";
        }else{
            userRepository.save(user);
            return "redirect:index";
        }


    }

}
