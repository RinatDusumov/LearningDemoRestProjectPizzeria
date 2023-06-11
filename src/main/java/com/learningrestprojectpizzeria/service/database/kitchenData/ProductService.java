package com.learningrestprojectpizzeria.service.database.kitchenData;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getAllProducts();
    public void save(Products products);
    public Products getProductsById(int id);
    public void deleteProductsById(int id);
    public Products getProductBalance(String name);
}
