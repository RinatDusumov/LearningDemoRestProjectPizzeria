package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO extends JpaRepository<Orders, Integer> {
    public List<Orders> findOrdersByOrderTimeBetween(Timestamp startDate, Timestamp endDate);


    public List<Orders> findOrdersByOrderTime(Timestamp date);
}