package com.learningrestprojectpizzeria.models.management;

import com.learningrestprojectpizzeria.models.hrEntity.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "pizzerias")
@Data
@NoArgsConstructor
public class Pizzerias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String Address;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PizzeriasId")
    private List<Employee> employees;

    @Column(name = "DateOfCreation")
    private Timestamp dateOfCreation;

    public Pizzerias(String name, String address, String phoneNumber) {
        this.name = name;
        Address = address;
        this.phoneNumber = phoneNumber;
    }
}