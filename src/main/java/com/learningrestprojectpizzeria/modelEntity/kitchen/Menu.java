package com.learningrestprojectpizzeria.modelEntity.kitchen;

import com.learningrestprojectpizzeria.modelEntity.salesEntity.Orders;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Category")
    @NotBlank
    @Max(value = 20)
    private String category;

    @Column(name = "Dish_name")
    @NotBlank
    @Max(value = 50)
    private String dishName;

    @Column(name = "Serving_type")
    @NotBlank
    @Max(value = 20)
    private String servingType;

    @Column(name = "Price")
    @NotBlank
    private Double price;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "PositionId")
    private List<Orders> orders;

    public Menu(String category, String dishName, String servingType, Double price) {
        this.category = category;
        this.dishName = dishName;
        this.servingType = servingType;
        this.price = price;
    }
}