package com.learningrestprojectpizzeria.dao.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Parishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParishesRepository extends JpaRepository<Parishes, Integer> {
}