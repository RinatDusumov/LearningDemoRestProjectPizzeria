package com.learningrestprojectpizzeria.modelEntity.kitchen;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "parishes")
@Data
@NoArgsConstructor
public class Parishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotBlank
    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "OrderTime")
    private Timestamp orderTime;

    public Parishes(Integer quantity) {
        this.quantity = quantity;
    }
}