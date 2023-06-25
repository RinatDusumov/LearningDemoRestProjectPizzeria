package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getAllProducts();
    public void saveProduct (Products product);
    public Products getProductById(int id);
    public void deleteProductById(int id);
    public ProductAccounting findProductsEntitiesByName(String nameProduct);
}
