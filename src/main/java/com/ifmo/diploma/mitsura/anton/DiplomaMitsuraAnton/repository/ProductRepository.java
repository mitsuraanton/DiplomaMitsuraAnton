package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findByProductGroupId(int productGroupId);
}
