package com.example.aplication_loger;

import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface User_Repo  extends JpaRepository<User, Long> {
    List<User> findByEmailAndLoginAndPasswordEquals(String email, String login,String password);


    public boolean existsByEmailAndLoginAndPassword(String email, String login,String password);
    public boolean existsByEmailOrLogin(String email,String login);
}
