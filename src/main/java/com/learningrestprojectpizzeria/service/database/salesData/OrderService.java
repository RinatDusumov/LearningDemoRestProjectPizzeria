package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.modelEntity.salesEntity.Orders;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public List<Orders> getAllOrders();
    public void saveOrder (Orders order);
    public Orders getOrdersById (int id);
    public void deleteOrderById (int id);
    public List<Orders> findByOrderTimeBetween(Timestamp startDate, Timestamp endDate);

}