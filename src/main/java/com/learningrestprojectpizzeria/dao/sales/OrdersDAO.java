package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
    @Query(value = "select Menu.category, sum(Menu.price * Orders.quantity) " +
            "from Orders where Orders.orderTime between :startDate and :endDate group by Menu.category",
            nativeQuery = true)
    public List<Orders> findByOrderTimeBetween(@Param("startDate") Timestamp startDate,
                                               @Param("endDate") Timestamp endDate);
}