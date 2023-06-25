package com.learningrestprojectpizzeria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Min(value = 1)
    @Column(name = "consumption_quantity")
    private Integer consumptionQuantity;

    @Column(name = "order_time")
    private Timestamp orderTime;

    public Expenses(Integer consumptionQuantity)
    {
        this.consumptionQuantity = consumptionQuantity;
    }
}