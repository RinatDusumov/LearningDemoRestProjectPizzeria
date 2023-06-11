package com.learningrestprojectpizzeria.dao.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query(value = "select Products.name, Products.category, Products.unitMeasurement, " +
            "sum(Parishes.quantity + Expenses.quantity)) as Remains" +
            "from Products where Products.name = :name",
            nativeQuery = true)
    public Products getProductsByName(@Param("name") String name);
}