package com.learningrestprojectpizzeria.service.database.sales;

import com.learningrestprojectpizzeria.model.dto.PaidMeals;
import com.learningrestprojectpizzeria.model.dto.ProductReceipt;
import com.learningrestprojectpizzeria.model.entity.OrderDetailsEntity;
import com.learningrestprojectpizzeria.model.entity.Orders;
import com.learningrestprojectpizzeria.repository.OrderDAO;
import com.learningrestprojectpizzeria.service.utility.calculations.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderRepository;

    @Override
    public String paymentConfirmation (ProductReceipt productReceipt) {
        return "Successfully paid";
    }

    @Override
    public ProductReceipt receivingPaymentData(Orders order) {
        List<PaidMeals> paidMeals = new LinkedList<>();
        for (OrderDetailsEntity orderDetails : order.getOrderDetails()) {
            paidMeals.add(new PaidMeals(orderDetails.getMenuPositions().getDishName(),
                    orderDetails.getMenuPositions().getPrice(),
                    orderDetails.getQuantity(),
                    orderDetails.getMenuPositions().getPrice() * orderDetails.getQuantity()));
        }

        return new ProductReceipt(paidMeals, Calculator.calculationOfTheTotalAmount(paidMeals));
    }


    @Override
    public List<ProductReceipt> findOrdersByOrderTimeBetween(Timestamp startDate, Timestamp endDate) {
        List<ProductReceipt> productReceipt = new LinkedList<>();

        List<Orders> reportOrdersByOrderTimeBetween = orderRepository.findOrdersByOrderTimeBetween(startDate, endDate);
        for (Orders order : reportOrdersByOrderTimeBetween) {
            productReceipt.add(receivingPaymentData(order));
        }
        return productReceipt;
    }

    @Override
    public List<ProductReceipt> findOrdersByOrderTime(Timestamp date) {
        List<ProductReceipt> productReceipt = new LinkedList<>();
        List<Orders> reportOrdersByOrderTime = orderRepository.findOrdersByOrderTime(date);
        for (Orders order : reportOrdersByOrderTime) {
            productReceipt.add(receivingPaymentData(order));
        }
        return productReceipt;
    }

    @Override
    public List<Orders> getAllOrders() {

        return orderRepository.findAll();
    }
    @Override
    public Orders saveOrder(Orders order) {

        Orders newOrder = orderRepository.save(order);
        return newOrder;
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