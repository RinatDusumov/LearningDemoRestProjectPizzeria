package com.learningrestprojectpizzeria.service.database.sales;

import com.learningrestprojectpizzeria.model.dto.ProductReceipt;
import com.learningrestprojectpizzeria.model.entity.Orders;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public List<Orders> getAllOrders();
    public Orders saveOrder (Orders order);
    public Orders getOrdersById (int id);
    public void deleteOrderById (int id);
    public List<ProductReceipt> findOrdersByOrderTimeBetween(Timestamp startDate, Timestamp endDate);

    public List<ProductReceipt> findOrdersByOrderTime(Timestamp date);
    public ProductReceipt receivingPaymentData (Orders order);

    public String paymentConfirmation (ProductReceipt productReceipt);
    public List<Orders> findOrdersByItCookedIsFalse();
}