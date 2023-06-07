package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;

import java.util.List;

public interface OrdersDAO {
    public List<Orders> getAllOrders();
    public void saveOrder(Orders order);
    public List<Orders> getOrders(int id);
    public void deleteOrder(int id);
    public Double getTheFullAmountOfTheOrder(int id);

    public List<WeeklyReports> gettingDataForReport();
}