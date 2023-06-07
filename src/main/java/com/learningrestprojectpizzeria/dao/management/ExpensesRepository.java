package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
}