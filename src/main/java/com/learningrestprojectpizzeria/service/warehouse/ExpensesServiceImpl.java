package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Expenses;
import com.learningrestprojectpizzeria.repository.ExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesServiceImpl implements ExpensesService {
    @Autowired
    private ExpensesDAO expensesRepository;

    @Override
    public List<Expenses> getAllExpenses() {

        return expensesRepository.findAll();
    }

    @Override
    public void saveExpenses(Expenses expenses) {

        if (expenses.getConsumptionQuantity() > 0) {
            expenses.setConsumptionQuantity(Math.negateExact(expenses.getConsumptionQuantity()));
        }
        expensesRepository.save(expenses);
    }

    @Override
    public Expenses getExpensesById(int id) {
        Expenses expenses = null;
        Optional<Expenses> optional = expensesRepository.findById(id);
        if(optional.isPresent()) {
            expenses = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return expenses;
    }

    @Override
    public void deleteExpensesById(int id) {
        Optional<Expenses> optional = expensesRepository.findById(id);
        if (optional.isPresent()) {
            expensesRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}
