package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findByProductGroupId(int productGroupId);
}
