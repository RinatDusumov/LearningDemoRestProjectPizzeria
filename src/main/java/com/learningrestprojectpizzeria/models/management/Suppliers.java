package com.learningrestprojectpizzeria.models.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotBlank
    @Column(name = "CompanyName")
    private String companyName;

    @NotBlank
    @Column(name = "Address")
    private String address;

    @NotBlank
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "SupplierId")
    private List<Parishes> parishesList;

    public Suppliers(String companyName, String address, String phoneNumber) {
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}