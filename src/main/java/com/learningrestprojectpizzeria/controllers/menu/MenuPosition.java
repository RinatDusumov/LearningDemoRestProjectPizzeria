package com.learningrestprojectpizzeria.controllers.menu;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import com.learningrestprojectpizzeria.service.menu.MenuPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuPosition {
    @Autowired
    private MenuPositionService menuPositionService;

    @GetMapping("/manage/remaining_products/nameProduct/{name}")
    public ProductAccounting getRemainingProductsByName (@PathVariable String nameProduct) {

        return menuPositionService.getRemainingProductsByName(nameProduct);
    }

    @GetMapping("/manage/menu_positions")
    public List<MenuPositions> getAllPositions() {
        List<MenuPositions> allPositions = menuPositionService.getAllPositions();
        return allPositions;
    }

    @GetMapping("/manage/menu_positions/{id}")
    public MenuPositions getPositionById(@PathVariable int id) {
        MenuPositions positions = menuPositionService.getPositionById(id);
        return positions;
    }

    @PostMapping("/manage/menu_positions")
    public MenuPositions addNewPosition(@RequestBody MenuPositions position) {
        menuPositionService.savePosition(position);
        return position;
    }

    @PutMapping("/manage/menu_positions")
    public MenuPositions updatePositons(@RequestBody MenuPositions position) {
        menuPositionService.savePosition(position);
        return position;
    }

    @DeleteMapping("/manage/menu_positions/{id}")
    public String deletePositionById(@PathVariable int id) {
        menuPositionService.deletePositionById(id);
        return "Menu position with ID = " + id + " was deleted.";
    }

}
