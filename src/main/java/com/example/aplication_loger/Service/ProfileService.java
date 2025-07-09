package com.example.aplication_loger.Service;

import com.example.aplication_loger.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileService {

    User user;
    @GetMapping("/information")
    public String Profile(){



        return "information";
    }

}
