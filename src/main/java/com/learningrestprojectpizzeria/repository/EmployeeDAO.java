package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employees, Integer> {
    public List<Employees> findAllByFirstName(String firstName);
}