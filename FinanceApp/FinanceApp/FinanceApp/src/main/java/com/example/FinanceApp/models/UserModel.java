package com.example.FinanceApp.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("username")
    @Column(nullable = false, length = 100)
    private String username;

    @JsonProperty("email")
    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("joinDate")
    @Column(name = "join_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate = new Date();

    public UserModel(int id, String username, String email, String password, Date joinDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

}
