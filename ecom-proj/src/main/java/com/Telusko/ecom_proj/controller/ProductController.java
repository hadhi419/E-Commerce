package com.Telusko.ecom_proj.controller;

import com.Telusko.ecom_proj.model.Product;
import com.Telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping("/product/{pid}")
    public ResponseEntity<Product> getProduct(@PathVariable("pid") int id)
    {
        Product product = service.getProduct(id);

        if(product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
