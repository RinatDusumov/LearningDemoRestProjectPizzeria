package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Integer> {
    @Query(value = "select Products.name, " +
            "Products.category, " +
            "Products.unitMeasurement, " +
            "sum(Parishes.numberOfArrivals + Expenses.consumptionQuantity)) as Remains" +
            "from Products " +
            "where Products.name = :name " +
            "group by Products.name",
            nativeQuery = true)
    public ProductAccounting findProductsEntitiesByName(@Param("name") String nameProduct);

}