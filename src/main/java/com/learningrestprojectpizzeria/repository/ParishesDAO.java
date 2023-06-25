package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Parishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParishesDAO extends JpaRepository<Parishes, Integer> {
}