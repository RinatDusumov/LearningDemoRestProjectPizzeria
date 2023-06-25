package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Parishes;

import java.util.List;

public interface ParishesService {
    public List<Parishes> getAllParishes();
    public void saveParishes (Parishes parishes);
    public Parishes getParishesById (int id);
    public void deleteParishesById (int id);
}
