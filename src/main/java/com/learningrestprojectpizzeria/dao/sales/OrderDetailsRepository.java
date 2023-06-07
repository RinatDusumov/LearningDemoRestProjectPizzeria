package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.models.salesEntity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}