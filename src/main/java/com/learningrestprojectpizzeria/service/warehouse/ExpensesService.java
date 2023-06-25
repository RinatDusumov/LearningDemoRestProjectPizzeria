package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Expenses;

import java.util.List;

public interface ExpensesService {
    public List<Expenses> getAllExpenses();
    public void saveExpenses (Expenses expenses);
    public Expenses getExpensesById (int id);
    public void deleteExpensesById (int id);
}
