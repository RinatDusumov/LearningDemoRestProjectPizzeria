package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class ProductReceipt {
    private List<PaidMeals> paidMeals;
    private Double totalAmount;

    public ProductReceipt(List<PaidMeals> paidMeals, Double totalAmount) {
        this.paidMeals = paidMeals;
        this.totalAmount = totalAmount;
    }
}