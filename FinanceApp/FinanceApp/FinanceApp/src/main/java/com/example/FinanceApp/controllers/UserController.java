package com.example.FinanceApp.controllers;

import com.example.FinanceApp.models.UserModel;
import com.example.FinanceApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> userSignup(@RequestBody UserModel user) {
        Map<String, String> response = new HashMap<>();
        try {
            userRepo.save(user);
            response.put("status", "success");
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "failed");
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> userLogin(@RequestBody UserModel user) {
        List<UserModel> validUsers = userRepo.loginValidation(user.getEmail(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        if (!validUsers.isEmpty()) {
            response.put("status", "success");
            response.put("userId", String.valueOf(validUsers.get(0).getId()));
            response.put("username", validUsers.get(0).getUsername());
        } else {
            response.put("status", "failed");
        }
        return ResponseEntity.ok(response);
    }
}
