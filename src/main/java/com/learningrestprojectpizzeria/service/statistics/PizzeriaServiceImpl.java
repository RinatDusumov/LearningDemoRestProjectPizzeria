package com.learningrestprojectpizzeria.service.statistics;

import com.learningrestprojectpizzeria.model.entity.Pizzerias;
import com.learningrestprojectpizzeria.repository.PizzeriasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {
    @Autowired
    private PizzeriasDAO pizzeriasRepository;

    @Override
    public List<Pizzerias> getAllPizzerias() {

        return pizzeriasRepository.findAll();
    }

    @Override
    public void savePizzeria(Pizzerias pizzeria) {

        Pizzerias newPizzeria = pizzeriasRepository.save(pizzeria);
    }

    @Override
    public Pizzerias getPizzeriaById(int id) {
        Pizzerias pizzeria = null;
        Optional<Pizzerias> optional = pizzeriasRepository.findById(id);
        if(optional.isPresent()) {
            pizzeria = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return pizzeria;
    }

    @Override
    public void deletePizzeriaById(int id) {
        Optional<Pizzerias> optional = pizzeriasRepository.findById(id);
        if (optional.isPresent()) {
            pizzeriasRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}
