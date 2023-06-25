package com.learningrestprojectpizzeria.service.statistics.sales;

import com.learningrestprojectpizzeria.model.entity.OrderDetailsEntity;

import java.util.List;

public interface OrderDetailsService {
    public List<OrderDetailsEntity> getAllOrderDetails();
    public void saveOrderDetails (OrderDetailsEntity orderDetails);
    public OrderDetailsEntity getOrderDetailsById (int id);
    public void deleteOrderDetailsById(int id);
}
