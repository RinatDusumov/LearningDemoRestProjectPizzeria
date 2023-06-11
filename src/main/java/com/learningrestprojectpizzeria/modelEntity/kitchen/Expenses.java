package com.learningrestprojectpizzeria.modelEntity.kitchen;

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
    @Column(name = "Id")
    private Integer id;

    @NotBlank
    @Min(value = 1)
    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "OrderTime")
    private Timestamp orderTime;

    public Expenses(Integer quantity) {
        this.quantity = quantity;
    }
}