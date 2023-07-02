package com.learningrestprojectpizzeria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "menu_position")
@Data
@NoArgsConstructor
public class MenuPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Max(value = 20)
    @Column(name = "category")
    private String category;

    @NotBlank
    @Max(value = 50)
    @Column(name = "dish_name")
    private String dishName;

    @NotBlank
    @Max(value = 20)
    @Column(name = "serving_type")
    private String servingType;

    @NotBlank
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "menuPositions",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetails;

    @OneToMany(cascade = {CascadeType.DETACH,
                          CascadeType.MERGE,
                          CascadeType.PERSIST,
                          CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_position_id")
    private List<Products> products;

    public MenuPositions(String category, String dishName, String servingType, Double price) {
        this.category = category;
        this.dishName = dishName;
        this.servingType = servingType;
        this.price = price;
    }
}