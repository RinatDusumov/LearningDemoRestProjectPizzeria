package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor

public class ReportOrders {
    private String category;
    private String dishName;
    private String servingType;
    private Double price;
    private Integer sold;
    private Double profit;

    public ReportOrders(String category, String dishName,
                        String servingType, Double price,
                        Integer sold, Double profit) {
        this.category = category;
        this.dishName = dishName;
        this.servingType = servingType;
        this.price = price;
        this.sold = sold;
        this.profit = profit;
    }
}
