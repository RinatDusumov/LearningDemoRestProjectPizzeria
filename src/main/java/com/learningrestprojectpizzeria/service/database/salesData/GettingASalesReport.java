package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.service.database.salesData.OrdersService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.Callable;

@Component
@Data
@NoArgsConstructor
public class GettingASalesReport implements Callable<List<Orders>> {

    @Autowired
    private OrdersService orderService;

    private Timestamp startDate;
    private Timestamp endDate;
    @Override
    public List<Orders> call() throws Exception {
        return orderService.findByOrderTimeBetween(startDate, endDate);
    }

    public GettingASalesReport(Timestamp startDate, Timestamp endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}