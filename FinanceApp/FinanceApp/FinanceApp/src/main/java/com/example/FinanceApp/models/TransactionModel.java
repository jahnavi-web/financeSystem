package com.example.FinanceApp.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("transactionType")
    private String transactionType; // Income or Expense

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;

    @JsonProperty("date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @JsonProperty("notes")
    private String notes;

    public TransactionModel(int transactionId, int userId, String transactionType, double amount, String category, Date date, String notes) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    public TransactionModel() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
