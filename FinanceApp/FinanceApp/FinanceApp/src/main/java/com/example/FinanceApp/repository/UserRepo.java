package com.example.FinanceApp.repository;

import com.example.FinanceApp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT * FROM users WHERE email = ?1 AND password = ?2", nativeQuery = true)
    List<UserModel> loginValidation(String email, String password);
}
