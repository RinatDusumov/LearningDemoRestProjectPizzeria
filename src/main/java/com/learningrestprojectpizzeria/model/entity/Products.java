package com.learningrestprojectpizzeria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "in_quantity")
    private Integer inQuantity;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "category")
    private String category;

    @NotBlank
    @Column(name = "unit_measurement")
    private String unitMeasurement;

    @NotBlank
    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private List<Parishes> parishes;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private List<Expenses> expenses;

    public Products(Integer inQuantity, String name,
                    String category, String unitMeasurement,
                    Double pricePerUnit) {
        this.inQuantity = inQuantity;
        this.name = name;
        this.category = category;
        this.unitMeasurement = unitMeasurement;
        this.pricePerUnit = pricePerUnit;
    }
}