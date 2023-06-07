package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Parishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParishesRepository extends JpaRepository<Parishes, Integer> {
}