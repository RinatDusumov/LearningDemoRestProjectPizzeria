package com.learningrestprojectpizzeria.controllers.sales;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.service.database.salesData.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Orders> getOrderById(@PathVariable int id) {
        List<Orders> orders = ordersService.getOrdersById(id);
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

    @GetMapping("/orders/cheque/{id}")
    public Map<List<Orders>, Double> getFullOrderAmount(@PathVariable int id) {
        Map<List<Orders>, Double> cheque = new HashMap<>();
        cheque.put(ordersService.getOrdersById(id), ordersService.getTheFullAmountOfTheOrder(id));
        return cheque;
    }
}