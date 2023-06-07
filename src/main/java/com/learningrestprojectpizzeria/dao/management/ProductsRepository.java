package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}