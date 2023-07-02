package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PaidMeals {
    private String nameOfTheDish;
    private Double unitPrice;
    private Integer Quantity;
    private Double theAmount;

    public PaidMeals(String nameOfTheDish, Double unitPrice, Integer quantity, Double theAmount) {
        this.nameOfTheDish = nameOfTheDish;
        this.unitPrice = unitPrice;
        Quantity = quantity;
        this.theAmount = theAmount;
    }
}