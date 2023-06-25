package com.learningrestprojectpizzeria.service.statistics.sales;

import com.learningrestprojectpizzeria.model.entity.OrderDetailsEntity;
import com.learningrestprojectpizzeria.repository.OrderDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;
    @Override
    public List<OrderDetailsEntity> getAllOrderDetails() {
        return orderDetailsDAO.findAll();
    }

    @Override
    public void saveOrderDetails(OrderDetailsEntity orderDetails) {
        orderDetailsDAO.save(orderDetails);
    }

    @Override
    public OrderDetailsEntity getOrderDetailsById(int id) {
        OrderDetailsEntity orderDetails = null;
        Optional<OrderDetailsEntity> optional = orderDetailsDAO.findById(id);
        if(optional.isPresent()) {
            orderDetails = optional.get();
        }
        return orderDetails;
    }

    @Override
    public void deleteOrderDetailsById(int id) {
        Optional<OrderDetailsEntity> optional = orderDetailsDAO.findById(id);
        if (optional.isPresent()) {
            orderDetailsDAO.deleteById(id);
        }
    }
}