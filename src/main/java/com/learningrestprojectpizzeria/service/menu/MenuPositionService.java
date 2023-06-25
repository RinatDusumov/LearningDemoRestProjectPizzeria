package com.learningrestprojectpizzeria.service.menu;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.MenuPositions;

import java.util.List;

public interface MenuPositionService {
    public List<MenuPositions> getAllPositions();
    public void savePosition (MenuPositions position);
    public MenuPositions getPositionById (int id);
    public void deletePositionById (int id);
}