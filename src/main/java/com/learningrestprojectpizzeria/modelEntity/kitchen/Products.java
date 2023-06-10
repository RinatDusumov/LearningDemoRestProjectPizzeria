package com.learningrestprojectpizzeria.modelEntity.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Expenses;
import com.learningrestprojectpizzeria.modelEntity.kitchen.Parishes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotBlank
    @Column (name = "Name")
    private String name;

    @NotBlank
    @Column(name = "Category")
    private String category;

    @NotBlank
    @Column(name = "UnitMeasurement")
    private String unitMeasurement;

    @NotBlank
    @Column(name = "PricePerUnit")
    private Double pricePerUnit;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductId")
    private List<Parishes> parishesList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductId")
    private List<Expenses> expensesList;

    public Products(String name, String category, String unitMeasurement, Double pricePerUnit) {
        this.name = name;
        this.category = category;
        this.unitMeasurement = unitMeasurement;
        this.pricePerUnit = pricePerUnit;
    }
}