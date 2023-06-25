package com.learningrestprojectpizzeria.controllers.warehouse;

import com.learningrestprojectpizzeria.service.warehouse.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Expenses {
    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/manage/expenses")
    public List<com.learningrestprojectpizzeria.model.entity.Expenses> getAllExpenses() {
        List<com.learningrestprojectpizzeria.model.entity.Expenses> allExpenses = expensesService.getAllExpenses();
        return allExpenses;
    }

    @GetMapping("/manage/expenses/{id}")
    public com.learningrestprojectpizzeria.model.entity.Expenses getExpensesById(@PathVariable int id) {
        com.learningrestprojectpizzeria.model.entity.Expenses expenses = expensesService.getExpensesById(id);
        return expenses;
    }

    @PostMapping("/manage/expenses")
    public com.learningrestprojectpizzeria.model.entity.Expenses addNewExpenses(@RequestBody com.learningrestprojectpizzeria.model.entity.Expenses expenses) {
        expensesService.saveExpenses(expenses);
        return expenses;
    }

    @PutMapping("/manage/expenses")
    public com.learningrestprojectpizzeria.model.entity.Expenses updateExpenses(@RequestBody com.learningrestprojectpizzeria.model.entity.Expenses expenses) {
        expensesService.saveExpenses(expenses);
        return expenses;
    }

    @DeleteMapping("/manage/expenses/{id}")
    public String deleteExpensesById(@PathVariable int id) {
        expensesService.deleteExpensesById(id);
        return "Expenses with ID = " + id + " was deleted.";
    }
}
