package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.dao.sales.OrdersDAO;
import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDAO orderDAO;

    @Override
    @Transactional
    public List<Orders> getAllOrders() {

        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void saveOrder(Orders order) {

        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public List<Orders> getOrdersById(int id) {
        List<Orders> order = orderDAO.getOrders(id);
        if (order != null) {
            return order;

            //TODO если optional пуст можно выбрасывать исключение
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteOrderById(int id) {
        List<Orders> order = orderDAO.getOrders(id);
        if (order != null) {
            orderDAO.deleteOrder(id);

            //TODO если optional пуст можно выбрасывать исключение

        }
    }

    @Override
    @Transactional
    public Double getTheFullAmountOfTheOrder(int id) {

        return orderDAO.getTheFullAmountOfTheOrder(id);
    }

    @Override
    @Transactional
    public List<WeeklyReports> gettingDataForReport() {
        return orderDAO.gettingDataForReport();
    }
}