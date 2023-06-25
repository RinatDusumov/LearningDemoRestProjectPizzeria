package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.dto.ReportOrders;
import com.learningrestprojectpizzeria.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO extends JpaRepository<Orders, Integer> {
    @Query(value = "select MenuPositionEntity.category, " +
            "MenuPositionEntity.dishName, " +
            "MenuPositionEntity.servingType, " +
            "MenuPositionEntity.price, " +
            "sum(OrderEntity.quantity) as Sold, " +
            "sum(MenuPositionEntity.price * OrderEntity.quantity) as Profit " +
            "from OrderEntity where OrderEntity.orderTime between :startDate and :endDate " +
            "group by MenuPositionEntity.category",
            nativeQuery = true)
    public List<ReportOrders> findOrderEntityByOrderTimeBetween(@Param("startDate") Timestamp startDate,
                                                                @Param("endDate") Timestamp endDate);

    @Query(value = "select MenuPositionEntity.category, " +
            "MenuPositionEntity.dishName, " +
            "MenuPositionEntity.servingType, " +
            "MenuPositionEntity.price, " +
            "sum(OrderEntity.quantity) as Sold, " +
            "sum(MenuPositionEntity.price * OrderEntity.quantity) as Profit " +
            "from OrderEntity where OrderEntity.orderTime =: date " +
            "group by MenuPositionEntity.category",
            nativeQuery = true)
    public List<ReportOrders> findOrderEntityByOrderTimeBetween(@Param("date") Timestamp date);


    @Query(value = "select * from OrderEntity " +
            "where OrderEntity.isItCooked =: isItCooked" +
            "order by OrderEntity.orderTime desc",
            nativeQuery = true)
    public List<Orders> findOrderEntityByIsItCooked(@Param("isItCooked") Boolean isItCooked);
}