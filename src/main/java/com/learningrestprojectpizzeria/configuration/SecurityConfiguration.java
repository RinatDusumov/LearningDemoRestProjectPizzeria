package com.learningrestprojectpizzeria.configuration;

import com.learningrestprojectpizzeria.dao.hr.EmployeeRepository;
import com.learningrestprojectpizzeria.models.hrEntity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Bean
    public UserDetailsService userDetailsService () {
        List<Employee> allEmployees = employeeRepository.findAll();

        List<UserDetails> users = new ArrayList<>();
        
        for (Employee employee : allEmployees) {
            UserDetails userDetails = User
                    .withUsername(employee.getLoginInput().getEmail())
                    .password(employee.getLoginInput().getPassword())
                    .roles(employee.getDepartment())
                    .build();
            users.add(userDetails);
        }

//        UserDetails userAdmin = User
//                .withUsername("Rinat")
//                .password(BCrypt.withDefaults().hashToString(12, "userAdmin".toCharArray()))
//                .roles(Roles.ADMIN.toString())
//                .build();

        return new InMemoryUserDetailsManager(users);
    }
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/employee","/employees/*").hasAnyRole("HR", "Human Resources")
                .requestMatchers(HttpMethod.PUT,"/orders", "/orders/cheque/{id}").hasAnyRole("Cashier", "Bartender")
                .requestMatchers("/orders", "/orders/*", "/orders/{beginning}-{end}").hasRole("Administrator")
                .requestMatchers("/expenses","/menus", "/parishes", "/pizzerias",
                        "/products", "/remains", "suppliers").hasAnyRole("Manager", "Administrator")

                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .successForwardUrl("куда перебросит после аутентификации");

//        .requestMatchers("", "").authenticated()
//        .anyRequest().permitAll();
//        .and()
//        .formLogin().permitAll();

        return http.build();
    }
}