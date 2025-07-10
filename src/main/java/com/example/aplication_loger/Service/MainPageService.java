package com.example.aplication_loger.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageService {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
