package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElse(null);
    }
}