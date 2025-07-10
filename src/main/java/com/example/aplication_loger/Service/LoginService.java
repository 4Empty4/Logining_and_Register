package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    private final UserRepository userRepository;
    private final HttpSession httpSession;
    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
    final String secretKey = "secrete";

    @Autowired
    public LoginService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    public String LoginCheck(User user) {
        logger.info("Attempting login check for user with email: {}", user.getEmail());

        try {
            String encryptedPassword = aesEncryptionDecryption.encrypt(user.getPassword(), secretKey);

            boolean userExists = userRepository.existsByEmailAndLoginAndPassword(
                    user.getEmail(),
                    user.getLogin(),
                    encryptedPassword
            );

            if (userExists) {
                logger.info("Login successful for user: {}", user.getEmail());
                // Зберігаємо email у сесії
                httpSession.setAttribute("userEmail", user.getEmail());
                return "redirect:/information";
            } else {
                logger.warn("Login failed - invalid credentials for user: {}", user.getEmail());
                return "redirect:/Login?error";
            }
        } catch (Exception e) {
            logger.error("Error during login check for user: {}", user.getEmail(), e);
            return "redirect:/Login?error";
        }
    }
}