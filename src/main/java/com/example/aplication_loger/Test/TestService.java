package com.example.aplication_loger.Test;

import com.example.aplication_loger.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestRepository userRepository;

    @Autowired
    public TestService(TestRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод для автентифікації користувача
    public UserRequestFormDto authenticate(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Невірний логін або пароль");
        }
        return toUserDto(user);
    }

    // Метод для конвертації User в UserResponseDto
    private UserRequestFormDto toUserDto(User user) {
        return new UserRequestFormDto(
                user.getId(),
                user.getLogin(),
                user.getEmail()
        );
    }
}
