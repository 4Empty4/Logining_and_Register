package com.example.aplication_loger;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

public class profil {

    @PostMapping("/profil")
    public String Profile(){

        return "inf_about_user";
    }

}
