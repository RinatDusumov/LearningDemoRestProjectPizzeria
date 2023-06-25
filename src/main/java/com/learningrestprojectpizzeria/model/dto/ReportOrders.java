package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ReportOrders {
    private String category;
    private String dishName;
    private String servingType;
    private Double price;
    private Integer totalNumberSold;
    private Double income;

    public ReportOrders(String category, String dishName,
                        String servingType, Double price,
                        Integer totalNumberSold, Double income) {
        this.category = category;
        this.dishName = dishName;
        this.servingType = servingType;
        this.price = price;
        this.totalNumberSold = totalNumberSold;
        this.income = income;
    }
}
