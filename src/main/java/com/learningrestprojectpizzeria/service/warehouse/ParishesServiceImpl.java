package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Parishes;
import com.learningrestprojectpizzeria.repository.ParishesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParishesServiceImpl implements ParishesService {
    @Autowired
    private ParishesDAO parishesRepository;

    @Override
    public List<Parishes> getAllParishes() {

        return parishesRepository.findAll();
    }

    @Override
    public void saveParishes(Parishes parishes) {

        Parishes newParishes = parishesRepository.save(parishes);
    }

    @Override
    public Parishes getParishesById(int id) {
        Parishes parishes = null;
        Optional<Parishes> optional = parishesRepository.findById(id);
        if(optional.isPresent()) {
            parishes = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return parishes;
    }

    @Override
    public void deleteParishesById(int id) {
        Optional<Parishes> optional = parishesRepository.findById(id);
        if (optional.isPresent()) {
            parishesRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}