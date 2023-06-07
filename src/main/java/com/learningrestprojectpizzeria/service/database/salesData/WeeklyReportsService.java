package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;

import java.util.List;

public interface WeeklyReportsService {
    public List<WeeklyReports> getAllPositions();
    public void savePosition (WeeklyReports position);
    public WeeklyReports getPositionById (int id);
    public void deletePositionById (int id);
}
