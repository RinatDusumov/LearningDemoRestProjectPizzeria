package com.learningrestprojectpizzeria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "phone_number")

    @Pattern(regexp = "(\\+?[1-9]?\\-[0-9]+\\-[0-9]+\\-[0-9]+)",
            message = "99-999-999-999")
    private String phoneNumber;

    @NotBlank
    @Column(name = "department")
    private String department;

    @NotBlank
    @Column(name = "salary")
    private Double salary;

    @Min(value = 18)
    @Column(name = "age")
    private Integer age;

    @NotBlank
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    private Logins login;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Orders> allOrders;

    @Column(name = "date_of_employment")
    private Timestamp dateOfEmployment;

    // TODO изменить связь. Одна пиццериа, много работников.
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "pizzerias_id")
    private Pizzerias pizzeria;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<OrderDetailsEntity> orderDetails;

    public Employees(String surname, String firstName,
                     String phoneNumber, String department, Double salary,
                     Integer age, LocalDate dateOfBirth) {
        this.surname = surname;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
}