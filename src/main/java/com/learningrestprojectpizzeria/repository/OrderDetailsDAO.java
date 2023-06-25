package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity, Integer> {
}