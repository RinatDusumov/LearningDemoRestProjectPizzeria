package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesDAO extends JpaRepository<Expenses, Integer> {
}