package com.example.aplication_loger.Controller;

import com.example.aplication_loger.Entity.User;
import com.example.aplication_loger.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserInfoController {

    private final UserService userService;

    @Autowired
    public UserInfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/information")
    public String showUserInformation(HttpSession session, Model model) {
        // Отримуємо email з сесії
        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail == null) {
            return "redirect:/Login";
        }

        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("user", user);
            return "information";
        }
        return "redirect:/Login";
    }
}