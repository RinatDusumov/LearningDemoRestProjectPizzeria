package com.learningrestprojectpizzeria.models.salesEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "weekly_reports")
@Data
@NoArgsConstructor
public class WeeklyReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Date")
    private Timestamp date;

    @Column(name = "Category")
    @NotBlank
    @Max(value = 20)
    private String category;

    @Column(name = "Dish_name")
    @NotBlank
    @Max(value = 50)
    private String dishName;

    @Column(name = "Price")
    @NotBlank
    private Double price;

    @NotBlank
    @Column(name = "Profit")
    private Double profit;

    public WeeklyReports(String category, String dishName, Double price, Double profit) {
        this.category = category;
        this.dishName = dishName;
        this.price = price;
        this.profit = profit;
    }
}