package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

  // Lombok annotation for logger (replaces manual LoggerFactory)
@Service
public class RegisterService {

    private final AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    private final String secretKey = "secrete";
      private static final Logger log = LoggerFactory.getLogger(RegisterService.class);

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {

        log.info("Attempting to register user with email: {}", user.getEmail());

        try {
            // Encrypt password
            String encryptedPassword = aesEncryptionDecryption.encrypt(user.getPassword(), secretKey);
            user.setPassword(encryptedPassword);
            log.debug("Password encrypted successfully for user: {}", user.getEmail());

            // Check if user exists
            if (userRepository.existsByEmailOrLogin(user.getEmail(), user.getLogin())) {
                log.warn("Registration failed - email or login already exists: email={}, login={}",
                        user.getEmail(), user.getLogin());
                return "redirect:/Register";
            }

            // Save new user
            userRepository.save(user);
            log.info("User registered successfully: email={}", user.getEmail());
            return "redirect:/index";

        } catch (Exception e) {
            log.error("Registration failed for user: {}", user.getEmail(), e);
            return "redirect:/Register?error";  // Optional: Add error query param
        }
    }
}