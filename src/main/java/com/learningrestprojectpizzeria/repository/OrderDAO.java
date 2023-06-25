package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.dto.ReportOrders;
import com.learningrestprojectpizzeria.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO extends JpaRepository<Orders, Integer> {
    @Query(value = "select " +
            "MenuPositions.category, " +
            "MenuPositions.dishName, " +
            "MenuPositions.servingType, " +
            "MenuPositions.price, " +
            "sum(Orders.quantity) as total_number_sold, " +
            "sum(MenuPositions.price * Orders.quantity) as income " +
            "from Orders " +
            "where Orders.orderTime between :startDate and :endDate " +
            "group by MenuPositions.category",
            nativeQuery = true)
    public List<ReportOrders> findOrderEntityByOrderTimeBetween(@Param("startDate") Timestamp startDate,
                                                                @Param("endDate") Timestamp endDate);

    @Query(value = "select " +
            "MenuPositions.category, " +
            "MenuPositions.dishName, " +
            "MenuPositions.servingType, " +
            "MenuPositions.price, " +
            "sum(Orders.quantity) as total_number_sold, " +
            "sum(MenuPositions.price * Orders.quantity) as income " +
            "from Orders " +
            "where Orders.orderTime =: date " +
            "group by MenuPositions.category",
            nativeQuery = true)
    public List<ReportOrders> findOrderEntityByOrderTimeBetween(@Param("date") Timestamp date);
}