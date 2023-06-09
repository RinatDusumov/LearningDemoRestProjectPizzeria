package com.learningrestprojectpizzeria.service.database.salesData;

import com.learningrestprojectpizzeria.dao.sales.OrdersDAO;
import com.learningrestprojectpizzeria.models.hrEntity.Employee;
import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDAO orderDAO;

    @Override
    @Transactional
    public List<Orders> getAllOrders() {

        return orderDAO.findAll();
    }

    @Override
    @Transactional
    public void saveOrder(Orders order) {

        orderDAO.save(order);
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteOrderById(int id) {
        Optional<Orders> optional = orderDAO.findById(id);
        if (optional.isPresent()) {
            orderDAO.deleteById(id);
        }
            //TODO если optional пуст можно выбрасывать исключение

    }

    @Override
    @Transactional
    public List<Orders> findByOrderTimeBetween(Timestamp beginning, Timestamp end) {
        return orderDAO.findByOrderTimeBetween(beginning, end);
    }
}