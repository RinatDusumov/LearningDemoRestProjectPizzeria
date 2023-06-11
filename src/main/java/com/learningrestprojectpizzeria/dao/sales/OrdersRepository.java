package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.modelEntity.salesEntity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select Menu.category, Menu.dishName, Menu.servingType, Menu.price, " +
            "sum(Orders.quantity) as Sold, " +
            "sum(Menu.price * Orders.quantity) as Profit " +
            "from Orders where Orders.orderTime between :startDate and :endDate group by Menu.category",
            nativeQuery = true)
    public List<Orders> findByOrderTimeBetween(@Param("startDate") Timestamp startDate,
                                               @Param("endDate") Timestamp endDate);
}