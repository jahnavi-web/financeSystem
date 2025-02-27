package com.example.FinanceApp.controllers;

import com.example.FinanceApp.models.TransactionModel;
import com.example.FinanceApp.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepo transactionRepo;

    @PostMapping("/transaction")
    public ResponseEntity<Map<String, String>> addTransaction(@RequestBody TransactionModel transaction) {
        transactionRepo.save(transaction);
        Map<String, String> response = Map.of(
                "status", "success",
                "message", "Transaction recorded successfully"
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transactions/{userId}")
    public ResponseEntity<List<TransactionModel>> getUserTransactions(@PathVariable int userId) {
        return ResponseEntity.ok(transactionRepo.findUserTransactions(userId));
    }

    @GetMapping("/expenses/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getTotalExpenses(@PathVariable int userId) {
        return ResponseEntity.ok(transactionRepo.getTotalExpensesByCategory(userId));
    }
}
