package com.learningrestprojectpizzeria.controllers.sales;

import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import com.learningrestprojectpizzeria.service.database.salesData.OrdersService;
import com.learningrestprojectpizzeria.service.database.salesData.WeeklyReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeeklyReportsController {
    @Autowired
    private WeeklyReportsService weeklyReportsService;

    @Autowired
    private OrdersService ordersService;

    @Scheduled(cron = "0 0 21 * * 5")
    public void addNewPosition () {
        List<WeeklyReports> positions = ordersService.gettingDataForReport();
        if (positions != null) {
            for (WeeklyReports position : positions) {
                weeklyReportsService.savePosition(position);
            }
        }
    }

    @GetMapping("/weekly_reports")
    public List<WeeklyReports> getAllPositions() {
        List<WeeklyReports> allPositions = weeklyReportsService.getAllPositions();
        return allPositions;
    }

    @GetMapping("/weekly_reports/{id}")
    public WeeklyReports getPositionById(@PathVariable int id) {
        WeeklyReports position = weeklyReportsService.getPositionById(id);
        return position;
    }

    @PutMapping("/weekly_reports")
    public WeeklyReports updatePosition(@RequestBody WeeklyReports position) {
        weeklyReportsService.savePosition(position);
        return position;
    }

    @DeleteMapping("/weekly_reports/{id}")
    public String deletePositionById(@PathVariable int id) {
        weeklyReportsService.deletePositionById(id);
        return "Position with ID = " + id + " was deleted.";
    }
}