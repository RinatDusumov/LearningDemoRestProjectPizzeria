package com.learningrestprojectpizzeria.service.utility.calculations;

import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculator {
    public double incomeCalculation(double income, Integer quantity, List<MenuPositions> positions) {
        for(MenuPositions position : positions) {
            income = position.getPrice() * quantity;
        }
        return income;
    }

    public double calculationOfTheAverageCheck(double income, int totalQuantity) {
        return income / (double) totalQuantity;
    }

    public int countingTheTotal(int totalQuantity, int quantity) {
        return totalQuantity += quantity;
    }
}