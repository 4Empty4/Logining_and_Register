package com.example.aplication_loger.Test;

public class UserRequestFormDto {
    private Long id;
    private String login;
    private String email;

    // Конструктор, геттери та сеттери
    public UserRequestFormDto(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    // Геттери
    public Long getId() { return id; }
    public String getLogin() { return login; }
    public String getEmail() { return email; }
}
