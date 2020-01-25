package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.ProductGroup;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductGroupController {
    private ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductGroupController(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    @GetMapping(value = "/product_groups")
    public Iterable<ProductGroup> findAll(){
        return productGroupRepository.findAll(); // вернется JSON строка
    }

    @GetMapping(value = "/product_groups/{id}")
    public Optional<ProductGroup> findId(@PathVariable int id){
        return productGroupRepository.findById(id); // вернется JSON строка
    }
}
