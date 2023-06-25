package com.learningrestprojectpizzeria.controllers.statistics;

import com.learningrestprojectpizzeria.model.dto.ReportOrders;
import com.learningrestprojectpizzeria.model.entity.Orders;
import com.learningrestprojectpizzeria.service.statistics.sales.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Order {
    @Autowired
    private OrderService orderService;

    @GetMapping("/manage/orders/date/{date}")
    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp startDate, Timestamp endDate) {
        return orderService.getReportOrdersTimeBetween(startDate, endDate);
    }

    @GetMapping("/manage/orders/date/{date}")
    public List<ReportOrders> getReportOrdersTimeBetween(Timestamp date) {
        return orderService.getReportOrdersTimeBetween(date);
    }

    @GetMapping("manage/orders")
    public List<Orders> getAllOrders() {
        List<Orders> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/manage/orders/{id}")
    public Orders getOrderById(@PathVariable int id) {
        Orders orders = orderService.getOrdersById(id);
        return orders;
    }

    @PostMapping("/manage/orders")
    public Orders addNewOrder(@RequestBody Orders order) {
        orderService.saveOrder(order);
        return order;
    }

    @PutMapping("/manage/orders")
    public Orders updateOrder(@RequestBody Orders order) {
        orderService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/manage/orders/{id}")
    public String deleteOrderById(@PathVariable int id) {
        orderService.deleteOrderById(id);
        return "Order with Id = " + id + " was deleted.";
    }
}