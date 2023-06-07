package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.dao.sales.WeeklyReportsRepository;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyReportsServiceImpl implements WeeklyReportsService {
    @Autowired
    private WeeklyReportsRepository weeklyReportsRepository;

    @Override
    public List<WeeklyReports> getAllPositions() {
        return weeklyReportsRepository.findAll();
    }

    @Override
    public void savePosition(WeeklyReports position) {

        weeklyReportsRepository.save(position);
    }

    @Override
    public WeeklyReports getPositionById(int id) {
        return null;
    }

    @Override
    public void deletePositionById(int id) {

    }
}