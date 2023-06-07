package com.learningrestprojectpizzeria.models.hrEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "login_input")
@Data
@NoArgsConstructor
public class LoginInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer loginInputID;

    @Column(name = "Email")
    @Email
    private String email;

    @Column(name = "Password")
    @NotBlank
    private String password;

    @Column(name = "DateOfLogin")
    private Timestamp dateOfLogin;

    public LoginInput(String email, String password) {
        this.email = email;
        this.password = password;
    }
}