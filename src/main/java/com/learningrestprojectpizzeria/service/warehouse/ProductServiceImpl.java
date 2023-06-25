package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.Products;
import com.learningrestprojectpizzeria.repository.ProductsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsDAO productsDAO;

    public ProductAccounting findProductsEntitiesByName(String nameProduct) {
        return productsDAO.findProductsEntitiesByName(nameProduct);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsDAO.findAll();
    }

    @Override
    public void saveProduct(Products product) {
        productsDAO.save(product);
    }

    @Override
    public Products getProductById(int id) {
        Products product = null;
        Optional<Products> optional = productsDAO.findById(id);
        if(optional.isPresent()) {
            product = optional.get();
        }
        return product;
    }

    @Override
    public void deleteProductById(int id) {
        Optional<Products> optional = productsDAO.findById(id);
        if(optional.isPresent()) {
            productsDAO.deleteById(id);
        }
    }
}
