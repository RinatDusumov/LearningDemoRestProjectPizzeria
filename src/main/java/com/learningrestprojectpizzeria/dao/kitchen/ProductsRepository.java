package com.learningrestprojectpizzeria.dao.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}