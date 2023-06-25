package com.learningrestprojectpizzeria.controllers.warehouse;

import com.learningrestprojectpizzeria.service.warehouse.ParishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Parishes {
    @Autowired
    private ParishesService parishesService;

    @GetMapping("/manage/parishes")
    public List<com.learningrestprojectpizzeria.model.entity.Parishes> getAllParishes() {
        List<com.learningrestprojectpizzeria.model.entity.Parishes> allParishes = parishesService.getAllParishes();
        return allParishes;
    }

    @GetMapping("/manage/parishes/{id}")
    public com.learningrestprojectpizzeria.model.entity.Parishes getParishesById(@PathVariable int id) {
        com.learningrestprojectpizzeria.model.entity.Parishes parishes = parishesService.getParishesById(id);
        return parishes;
    }

    @PostMapping("/manage/parishes")
    public com.learningrestprojectpizzeria.model.entity.Parishes addNewParishes(@RequestBody com.learningrestprojectpizzeria.model.entity.Parishes parishes) {
        parishesService.saveParishes(parishes);
        return parishes;
    }

    @PutMapping("/manage/parishes")
    public com.learningrestprojectpizzeria.model.entity.Parishes updateParishes(@RequestBody com.learningrestprojectpizzeria.model.entity.Parishes parishes) {
        parishesService.saveParishes(parishes);
        return parishes;
    }

    @DeleteMapping("/manage/parishes/{id}")
    public String deleteParishesById(@PathVariable int id) {
        parishesService.deleteParishesById(id);
        return "Parishes with ID = " + id + " was deleted.";
    }
}
