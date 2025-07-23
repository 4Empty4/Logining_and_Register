package com.example.aplication_loger.Test;

import com.example.aplication_loger.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository  extends JpaRepository<User, Long> {
    // Пошук користувача за логіном з використанням нативного SQL
    @Query(value = "SELECT * FROM users_inf WHERE login = :login", nativeQuery = true)
    User findByLogin(@Param("login") String login);

    // Перевірка існування користувача за логіном з використанням нативного SQL
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM users_inf WHERE login = :login", nativeQuery = true)
    boolean existsByLogin(@Param("login") String login);

    // Додатковий метод для пошуку за email з використанням SQL
    @Query(value = "SELECT * FROM users_inf WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
