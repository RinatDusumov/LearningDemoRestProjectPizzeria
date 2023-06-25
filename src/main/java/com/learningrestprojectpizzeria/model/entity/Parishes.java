package com.learningrestprojectpizzeria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Min(value = 1)
    @Column(name = "number_of_arrivals")
    private Integer numberOfArrivals;

    @Column(name = "order_time")
    private Timestamp orderTime;


    public Parishes(Integer numberOfArrivals) {

        this.numberOfArrivals = numberOfArrivals;
    }
}