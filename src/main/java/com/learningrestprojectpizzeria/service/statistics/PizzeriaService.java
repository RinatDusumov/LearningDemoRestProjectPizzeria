package com.learningrestprojectpizzeria.service.statistics;

import com.learningrestprojectpizzeria.model.entity.Pizzerias;

import java.util.List;

public interface PizzeriaService {
    public List<Pizzerias> getAllPizzerias();
    public void savePizzeria (Pizzerias pizzeria);
    public Pizzerias getPizzeriaById (int id);
    public void deletePizzeriaById (int id);
}
