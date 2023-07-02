package com.learningrestprojectpizzeria.service.database.sales;

import com.learningrestprojectpizzeria.model.dto.ReportOrders;
import com.learningrestprojectpizzeria.model.entity.Orders;
import com.learningrestprojectpizzeria.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderRepository;

    @Override
    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp startDate, Timestamp endDate) {
        return orderRepository.findOrderEntityByOrderTimeBetween(startDate, endDate);
    }

    @Override
    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp date) {
        return orderRepository.findOrderEntityByOrderTimeBetween(date);
    }

    @Override
    public List<Orders> getAllOrders() {

        return orderRepository.findAll();
    }
    @Override
    public void saveOrder(Orders order) {

        Orders newOrder = orderRepository.save(order);
    }

    @Override
    public Orders getOrdersById(int id) {
        Orders orders = null;
        Optional<Orders> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            orders = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return orders;
    }

    @Override
    public synchronized void deleteOrderById(int id) {
        Optional<Orders> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            orderRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}