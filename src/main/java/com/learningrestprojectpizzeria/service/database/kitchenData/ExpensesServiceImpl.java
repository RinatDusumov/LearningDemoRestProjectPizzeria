package com.learningrestprojectpizzeria.service.database.kitchenData;

import com.learningrestprojectpizzeria.dao.kitchen.ExpensesRepository;
import com.learningrestprojectpizzeria.modelEntity.kitchen.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }

    @Override
    public void save(Expenses expenses) {
        if (expenses.getQuantity() > 0) {
            expenses.setQuantity(Math.negateExact(expenses.getQuantity()));
        }
        expensesRepository.save(expenses);
    }

    @Override
    public Expenses getExpensesById(int id) {
        Expenses expenses = null;
        Optional<Expenses> optional = expensesRepository.findById(id);
        if (optional.isPresent()) {
            expenses = optional.get();
        }
        return expenses;
    }

    @Override
    public void deleteExpensesById(int id) {
        Optional<Expenses> optional = expensesRepository.findById(id);
        if (optional.isPresent()) {
            expensesRepository.deleteById(id);
        }
    }
}