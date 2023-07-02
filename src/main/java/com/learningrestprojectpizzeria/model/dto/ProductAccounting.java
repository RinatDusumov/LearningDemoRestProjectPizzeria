package com.learningrestprojectpizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class ProductAccounting {
    private String name;
    private String category;
    private String unitMeasurement;
    private Integer quantity;

    public ProductAccounting(String name, String category, String unitMeasurement, Integer quantity) {
        this.name = name;
        this.category = category;
        this.unitMeasurement = unitMeasurement;
        this.quantity = quantity;
    }
}