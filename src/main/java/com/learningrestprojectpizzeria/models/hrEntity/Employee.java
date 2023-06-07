package com.learningrestprojectpizzeria.models.hrEntity;

import com.learningrestprojectpizzeria.models.salesEntity.OrderDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer employeeID;

    @Column(name = "Surname")
    @NotBlank
    private String surname;

    @Column(name = "FirstName")
    @NotBlank
    private String firstName;

    @Column(name = "PhoneNumber")
    @Pattern(regexp = "\\+?\\d{2,4}\\-[0-9]{2,4}\\-[0-9]{2,4}\\-[0-9]{2,4}",
            message = "+99-999-999-999")
    private String phoneNumber;

    @Column(name = "Department")
    private String department;

    @Column(name = "Salary")
    private Double salary;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "LoginInputID")
    private LoginInput loginInput;

    @Column(name = "DateOfEmployment")
    private Timestamp dateOfEmployment;

    @OneToMany(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private List<OrderDetails> orderDetails;

    public Employee(String surname, String firstName,
                    String phoneNumber, String department, Double salary,
                    Integer age, Date dateOfBirth) {
        this.surname = surname;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
}