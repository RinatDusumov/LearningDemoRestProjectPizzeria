package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.dao.sales.OrdersRepository;
import com.learningrestprojectpizzeria.modelEntity.salesEntity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepository orderDAO;

    @Override
    public List<Orders> getAllOrders() {

        return orderDAO.findAll();
    }

    @Override
    public synchronized void saveOrder(Orders order) {

        orderDAO.save(order);
    }

    @Override
    public Orders getOrdersById(int id) {
        Orders orders = null;
        Optional<Orders> optional = orderDAO.findById(id);
        if(optional.isPresent()) {
            orders = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return orders;
    }

    @Override
    public synchronized void deleteOrderById(int id) {
        Optional<Orders> optional = orderDAO.findById(id);
        if (optional.isPresent()) {
            orderDAO.deleteById(id);
        }
            //TODO если optional пуст можно выбрасывать исключение

    }

    @Override
    public List<Orders> findByOrderTimeBetween(Timestamp startDate, Timestamp endDate) {
        return orderDAO.findByOrderTimeBetween(startDate, endDate);
    }
}