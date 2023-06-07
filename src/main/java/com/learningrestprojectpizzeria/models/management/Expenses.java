package com.learningrestprojectpizzeria.models.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Column(name = "Date")
    private Date date;

    @NotBlank
    @Column(name = "Quantity")
    private Integer quantity;

    public Expenses(Date date, Integer quantity) {
        this.date = date;
        this.quantity = quantity;
    }
}