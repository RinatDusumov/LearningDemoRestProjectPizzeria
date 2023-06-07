package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Pizzerias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriasRepository extends JpaRepository<Pizzerias, Integer> {
}