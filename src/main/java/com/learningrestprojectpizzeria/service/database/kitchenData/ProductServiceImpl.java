package com.learningrestprojectpizzeria.service.database.kitchenData;

import com.learningrestprojectpizzeria.dao.kitchen.ProductsRepository;
import com.learningrestprojectpizzeria.modelEntity.kitchen.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void save(Products products) {
        productsRepository.save(products);
    }

    @Override
    public Products getProductsById(int id) {
        Products products = null;
        Optional<Products> optional = productsRepository.findById(id);
        if (optional.isPresent()) {
            products = optional.get();
        }
        return products;
    }

    @Override
    public void deleteProductsById(int id) {
        Optional<Products> optional = productsRepository.findById(id);
        if (optional.isPresent()) {
            productsRepository.deleteById(id);
        }
    }

    public Products getProductBalance(String name) {

        return productsRepository.getProductsByName(name);
    }
}