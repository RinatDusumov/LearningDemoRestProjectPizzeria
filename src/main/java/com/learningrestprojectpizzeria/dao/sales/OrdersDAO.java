package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
    @Query("select Menu.category, sum(Menu.price * Orders.quantity) " +
            "from Orders where Orders.orderTime between ?1 and ?2 group by Menu.category")
    public List<Orders> findByOrderTimeBetween(Timestamp beginning, Timestamp end);
}