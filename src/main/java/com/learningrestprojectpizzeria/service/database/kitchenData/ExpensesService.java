package com.learningrestprojectpizzeria.service.database.kitchenData;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Expenses;

import java.util.List;

public interface ExpensesService {
    public List<Expenses> getAllExpenses();
    public void save(Expenses expenses);
    public Expenses getExpensesById(int id);
    public void deleteExpensesById(int id);
}