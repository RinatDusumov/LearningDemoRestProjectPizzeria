package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import java.util.List;

public interface OrdersService {
    public List<Orders> getAllOrders();
    public void saveOrder (Orders order);
    public List<Orders> getOrdersById (int id);
    public void deleteOrderById (int id);
    public Double getTheFullAmountOfTheOrder(int id);
    public List<WeeklyReports> gettingDataForReport();
}