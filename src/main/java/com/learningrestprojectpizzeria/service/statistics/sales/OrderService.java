package com.learningrestprojectpizzeria.service.statistics.sales;

import com.learningrestprojectpizzeria.model.dto.ReportOrders;
import com.learningrestprojectpizzeria.model.entity.Orders;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public List<Orders> getAllOrders();
    public void saveOrder (Orders order);
    public Orders getOrdersById (int id);
    public void deleteOrderById (int id);
    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp startDate, Timestamp endDate);

    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp date);

    public List<Orders> findAllOrdersByIsItCooked(Boolean isItCooked);

}