package com.learningrestprojectpizzeria.controllers.sales;

import com.learningrestprojectpizzeria.service.database.salesData.threadGettingASalesReport.GettingASalesReport;
import com.learningrestprojectpizzeria.modelEntity.salesEntity.Orders;
import com.learningrestprojectpizzeria.service.database.salesData.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api")
public class OrdersController {
    @Autowired
    private OrderService ordersService;

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
    public Orders addNewOrder(@RequestBody Orders order) {
        ordersService.saveOrder(order);
        return order;
    }

    @PutMapping("/orders")
    public Orders updateOrder(@RequestBody Orders order) {
        ordersService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderById(@PathVariable int id) {
        ordersService.deleteOrderById(id);
        return "Orders with ID = " + id + " was deleted.";
    }

    @GetMapping("/orders/date")
    public List<Orders> findByOrderTimeBetween(@RequestParam("startDate") Date startDate,
                                               @RequestParam("endDate") Date endDate) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Orders>> future = executorService.submit(new GettingASalesReport((Timestamp) startDate, (Timestamp) endDate));
        List<Orders> salesReport = future.get();

        executorService.shutdown();
        return salesReport;
    }
}