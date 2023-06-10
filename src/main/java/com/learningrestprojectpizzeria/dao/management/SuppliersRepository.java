package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.modelEntity.management.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Integer> {
}