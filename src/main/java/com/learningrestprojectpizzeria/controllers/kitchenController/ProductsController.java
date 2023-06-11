package com.learningrestprojectpizzeria.controllers.kitchenController;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Products;
import com.learningrestprojectpizzeria.service.database.kitchenData.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    private ProductService productsService;

    @GetMapping("/products")
    public List<Products> getAllProducts() {
        List<Products> allProducts = productsService.getAllProducts();
        return allProducts;
    }

    @GetMapping("/products/{id}")
    public Products getProductById(@PathVariable int id) {
        Products products = productsService.getProductsById(id);
        return products;
    }

    @PostMapping("/products")
    public Products addNewProducts(@RequestBody Products products) {
        productsService.save(products);
        return products;
    }

    @PutMapping("/products")
    public Products updateProducts(@RequestBody Products products) {
        productsService.save(products);
        return products;
    }
    
    @DeleteMapping("/products/{id}")
    public String deleteProductsById(@PathVariable int id) {
        productsService.deleteProductsById(id);
        return "Products with ID = " + id + " was deleted.";
    }

    @GetMapping("/products/name/{name}")
    public Products getProductBalance(@PathVariable String name) {
        Products productBalance = productsService.getProductBalance(name);
        return productBalance;
    }
}