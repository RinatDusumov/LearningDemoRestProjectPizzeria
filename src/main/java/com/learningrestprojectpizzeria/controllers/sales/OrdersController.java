package com.learningrestprojectpizzeria.controllers.sales;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.service.database.salesData.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        List<Orders> allOrders = ordersService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public Orders getOrderById(@PathVariable int id) {
        Orders orders = ordersService.getOrdersById(id);
        return orders;
    }

    @PostMapping("/orders")
    public Orders addNewOrder (@RequestBody Orders order) {
        ordersService.saveOrder(order);
        return order;
    }

    @PutMapping("/orders")
    public Orders updateOrder (@RequestBody Orders order) {
        ordersService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderById (@PathVariable int id) {
        ordersService.deleteOrderById(id);
        return "Orders with ID = " + id + " was deleted.";
    }

    @GetMapping("/orders/{beginning}-{end}")
    public List<Orders> findByOrderTimeBetween(@PathVariable Timestamp beginning,
                                   @PathVariable Timestamp end) {
        List<Orders> report = findByOrderTimeBetween(beginning, end);
        return report;
    }
}