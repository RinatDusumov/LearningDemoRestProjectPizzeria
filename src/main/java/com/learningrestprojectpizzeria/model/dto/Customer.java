package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private String fullName;
    private String phoneNumber;
    private double income;

    public Customer(String fullName, String phoneNumber, double income) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.income = income;
    }
}