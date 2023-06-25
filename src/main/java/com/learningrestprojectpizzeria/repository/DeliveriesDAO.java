package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesDAO extends JpaRepository<Deliveries, Integer> {
}