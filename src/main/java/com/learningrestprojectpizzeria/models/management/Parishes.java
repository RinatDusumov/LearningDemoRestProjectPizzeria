package com.learningrestprojectpizzeria.models.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Column(name = "DeliveryDate")
    private Date deliveryDate;

    @NotBlank
    @Column(name = "Quantity")
    private Integer quantity;

    public Parishes(Date deliveryDate, Integer quantity) {
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
    }
}