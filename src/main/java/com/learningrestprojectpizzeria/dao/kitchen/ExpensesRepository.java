package com.learningrestprojectpizzeria.dao.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
}