package com.Telusko.ecom_proj.service;

import com.Telusko.ecom_proj.model.Product;
import com.Telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        System.out.println("Products from DB: " + products);
        return products;
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }
}
