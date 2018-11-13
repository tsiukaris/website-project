package com.studying.web.backend.controller;


import com.studying.web.backend.dto.Product;
import com.studying.web.backend.exception.ResourceNotFoundException;
import com.studying.web.backend.repository.ProductRepository;
import com.studying.web.backend.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderedProductRepository ordProdRepository;

    @GetMapping("/api/store")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/api/store/{productid}")
    public Product getProductById(@PathVariable int productid){
        return productRepository.findById(productid).get();
    }

    @PostMapping("/api/store/addDbProduct")
    public Product createNewProduct(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/api/store/{productid}")
    public Product updateProduct(@PathVariable int productid, @RequestBody Product product){
        return productRepository.findById(productid).map((Product product1) -> {
            product1.setId(product.getId());
            product1.setCategory(product.getCategory());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            return productRepository.save(product1);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer not found by id" + productid));
    }
}
