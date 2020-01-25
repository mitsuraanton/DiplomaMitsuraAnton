package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products")
    public Iterable<Product> findAll(){
        return productRepository.findAll(); // вернется JSON строка
    }

    @GetMapping(value = "/products/{id}")
    public Optional<Product> findId(@PathVariable int id){
        return productRepository.findById(id); // вернется JSON строка
    }

    @GetMapping(value = "/products/by_group_id/{id}")
    public Iterable<Product> findGroupId(@PathVariable int id){
        return productRepository.findByProductGroupId(id); // вернется JSON строка
    }
}