package com.example.aplication_loger;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface User_Repo  extends JpaRepository<User, Long> {
    List<User> findByEmailAndAndLoginEquals(String email, String login);


    public boolean existsByEmailAndLogin(String email,String login);
    public boolean existsByEmailOrLoginOrName(String email,String login,String name);
}
