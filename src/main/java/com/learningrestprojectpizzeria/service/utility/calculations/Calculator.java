package com.learningrestprojectpizzeria.service.utility.calculations;

import com.learningrestprojectpizzeria.model.dto.PaidMeals;
import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculator {

    public static Double calculationOfTheTotalAmount(List<PaidMeals> paidMeals) {
        Double totalAmount = 0.0;
        for (PaidMeals paid : paidMeals) {
            totalAmount += paid.getTheAmount();
        }
        return totalAmount;
    }
}
