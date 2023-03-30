package com.example.aplication_loger;
import jakarta.persistence.*;

@Entity
@Table(name = "users_inf")
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
   private String name;
   private String login;
   private String email;
   private String password;
   private long phone_number;

  public User() {

  }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(String name, String login, String email, String password, long phone_number) {
    this.name = name;
    this.login = login;
    this.email = email;
    this.password = password;
    this.phone_number = phone_number;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(long phone_number) {
    this.phone_number = phone_number;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", login='" + login + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", phone_number=" + phone_number +
            '}';
  }
}
