package com.example.aplication_loger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class information {

    User user;
    @GetMapping("/information")
    public String Profile(){

        return "information";
    }

}
