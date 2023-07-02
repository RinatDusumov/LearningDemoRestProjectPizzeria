package com.learningrestprojectpizzeria.controllers.sales;

import com.learningrestprojectpizzeria.model.dto.ProductReceipt;
import com.learningrestprojectpizzeria.service.database.sales.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderManagement {
    @Autowired
    private OrderService orderService;

    @GetMapping("/manage/orders/date/{date}")
    public List<ProductReceipt> findOrdersByOrderTimeBetween(Timestamp startDate, Timestamp endDate) {
        return orderService.findOrdersByOrderTimeBetween(startDate, endDate);
    }

    @GetMapping("/manage/orders/date/{date}")
    public List<ProductReceipt> getReportOrdersTimeBetween(Timestamp date) {
        return orderService.findOrdersByOrderTime(date);
    }

    @GetMapping("manage/orders")
    public List<com.learningrestprojectpizzeria.model.entity.Orders> getAllOrders() {
        List<com.learningrestprojectpizzeria.model.entity.Orders> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/manage/orders/{id}")
    public com.learningrestprojectpizzeria.model.entity.Orders getOrderById(@PathVariable int id) {
        com.learningrestprojectpizzeria.model.entity.Orders orders = orderService.getOrdersById(id);
        return orders;
    }

    @PostMapping("/orders")
    public com.learningrestprojectpizzeria.model.entity.Orders addNewOrder(@RequestBody com.learningrestprojectpizzeria.model.entity.Orders order, Model model) {
        com.learningrestprojectpizzeria.model.entity.Orders completedOrder = orderService.saveOrder(order);
        model.addAttribute("completedOrder", completedOrder);
        return order;
    }

    @GetMapping("/orders/check")
    public ProductReceipt receivingPaymentData(@ModelAttribute("completedOrder") com.learningrestprojectpizzeria.model.entity.Orders order, Model model) {
        ProductReceipt paymentData = orderService.receivingPaymentData(order);
        model.addAttribute("paymentConfirmation", paymentData);
        return paymentData;
    }

    @PostMapping("/payment_confirmations")
    public String paymentConfirmation (@ModelAttribute("paymentConfirmation") ProductReceipt productReceipt) {
        return orderService.paymentConfirmation(productReceipt);
    }

    @PutMapping("/orders")
    public com.learningrestprojectpizzeria.model.entity.Orders updateOrder(@RequestBody com.learningrestprojectpizzeria.model.entity.Orders order) {
        orderService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderById(@PathVariable int id) {
        orderService.deleteOrderById(id);
        return "OrderManagement with Id = " + id + " was deleted.";
    }
}