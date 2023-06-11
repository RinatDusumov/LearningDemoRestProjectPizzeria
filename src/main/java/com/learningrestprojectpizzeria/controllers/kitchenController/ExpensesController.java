package com.learningrestprojectpizzeria.controllers.kitchenController;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Expenses;
import com.learningrestprojectpizzeria.service.database.kitchenData.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/expenses")
    public List<Expenses> getALlExpenses() {
        List<Expenses> allExpenses = expensesService.getAllExpenses();
        return allExpenses;
    }

    @GetMapping("/expenses/{id}")
    public Expenses getExpensesById(@PathVariable int id) {
        Expenses expenses = expensesService.getExpensesById(id);
        return expenses;
    }

    @PostMapping("/expenses")
    public Expenses addNewExpenses(@RequestBody Expenses expenses) {
        expensesService.save(expenses);
        return expenses;
    }

    @PutMapping("/expenses")
    public Expenses updateExpenses (@RequestBody Expenses expenses) {
        expensesService.save(expenses);
        return expenses;
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpensesById(@PathVariable int id) {
        expensesService.deleteExpensesById(id);
        return "Expenses with ID = " + id + " was deleted";
    }
}