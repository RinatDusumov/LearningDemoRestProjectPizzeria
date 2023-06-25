package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Pizzerias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriasDAO extends JpaRepository<Pizzerias, Integer> {
}