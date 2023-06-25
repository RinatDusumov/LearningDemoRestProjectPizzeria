package com.learningrestprojectpizzeria.service.menu;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import com.learningrestprojectpizzeria.repository.MenuPositionDAO;
import com.learningrestprojectpizzeria.service.warehouse.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuPositionServiceImpl implements MenuPositionService {
    @Autowired
    private MenuPositionDAO menuPositionRepository;

    @Override
    public List<MenuPositions> getAllPositions() {

        return menuPositionRepository.findAll();
    }

    @Override
    public void savePosition(MenuPositions position) {

        MenuPositions newPosition = menuPositionRepository.save(position);
    }

    @Override
    public MenuPositions getPositionById(int id) {
        MenuPositions position = null;
        Optional<MenuPositions> optional = menuPositionRepository.findById(id);
        if(optional.isPresent()) {
            position = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return position;
    }

    @Override
    public void deletePositionById(int id) {
        Optional<MenuPositions> optional = menuPositionRepository.findById(id);
        if (optional.isPresent()) {
            menuPositionRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}
