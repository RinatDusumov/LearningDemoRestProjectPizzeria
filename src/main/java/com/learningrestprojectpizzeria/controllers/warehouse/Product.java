package com.learningrestprojectpizzeria.controllers.warehouse;

import com.learningrestprojectpizzeria.model.dto.ProductAccounting;
import com.learningrestprojectpizzeria.model.entity.Products;
import com.learningrestprojectpizzeria.service.warehouse.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Product {

    @Autowired
    private ProductService productService;

    @GetMapping("/manage/remaining_products/nameProduct/{name}")
    public ProductAccounting getRemainingProductsByName (@PathVariable String nameProduct) {

        return productService.findProductsEntitiesByName(nameProduct);
    }

    @GetMapping("/manage/products")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/manage/products/{id}")
    public Products getProductsById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/manage/products")
    public Products addNewProduct (@RequestBody Products product) {
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("/manage/products")
    public Products updateProduct (@RequestBody Products product) {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/manage/products/{id}")
    public String deleteProducts (@PathVariable int id) {
        productService.deleteProductById(id);
        return "Product with id = " + id + " was deleted";
    }
}
