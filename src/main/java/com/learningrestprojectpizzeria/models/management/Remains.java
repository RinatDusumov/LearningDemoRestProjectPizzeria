package com.learningrestprojectpizzeria.models.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "remained")
@Data
@NoArgsConstructor
public class Remains {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotBlank
    @Column(name = "Quantity")
    private Integer quantity;

    public Remains(Integer quantity) {
        this.quantity = quantity;
    }
}