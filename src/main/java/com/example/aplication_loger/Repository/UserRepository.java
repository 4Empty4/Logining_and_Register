package com.example.aplication_loger.Repository;

import com.example.aplication_loger.Entity.User;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAndLoginAndPasswordEquals(String email, String login,String password);


    public boolean existsByEmailAndLoginAndPassword(String email, String login,String password);
    public boolean existsByEmailOrLogin(String email,String login);
}
