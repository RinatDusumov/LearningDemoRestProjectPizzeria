package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Integer> {
    @Query(value = "select ProductsEntity.name, " +
            "ProductsEntity.category, " +
            "ProductsEntity.unitMeasurement, " +
            "sum(ParishesEntity.numberOfArrivals + ExpensesEntity.consumptionQuantity)) as Remains" +
            "from ProductsEntity where ProductsEntity.name = :name " +
            "group by ProductsEntity.name",
            nativeQuery = true)
    public ProductAccounting findProductsEntitiesByName(@Param("name") String nameProduct);

}