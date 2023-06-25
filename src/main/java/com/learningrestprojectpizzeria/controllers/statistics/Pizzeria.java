package com.learningrestprojectpizzeria.controllers.statistics;

import com.learningrestprojectpizzeria.model.entity.Pizzerias;
import com.learningrestprojectpizzeria.service.statistics.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Pizzeria {

    @Autowired
    private PizzeriaService pizzeriaService;

    @GetMapping("/manage/pizzerias")
    public List<Pizzerias> getAllPizzerias() {
        List<Pizzerias> allPizzerias = pizzeriaService.getAllPizzerias();
        return allPizzerias;
    }

    @GetMapping("/manage/pizzerias/{id}")
    public Pizzerias getPizzeriaById(@PathVariable int id) {
        Pizzerias pizzerias = pizzeriaService.getPizzeriaById(id);
        return pizzerias;
    }

    @PostMapping("/manage/pizzerias")
    public Pizzerias addNewPizzeria(@RequestBody Pizzerias pizzeria) {
        pizzeriaService.savePizzeria(pizzeria);
        return pizzeria;
    }

    @PutMapping("/manage/pizzerias")
    public Pizzerias updatePizzeria(@RequestBody Pizzerias pizzeria) {
        pizzeriaService.savePizzeria(pizzeria);
        return pizzeria;
    }

    @DeleteMapping("/manage/pizzerias/{id}")
    public String deletePizzeriaById(@PathVariable int id) {
        pizzeriaService.deletePizzeriaById(id);
        return "Pizzeria with ID = " + id + " was deleted.";
    }

}
