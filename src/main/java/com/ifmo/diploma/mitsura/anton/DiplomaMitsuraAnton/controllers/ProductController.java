package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.ProductGroup;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductGroupRepository;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    private ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductGroupRepository productGroupRepository) {
        this.productRepository = productRepository;
        this.productGroupRepository = productGroupRepository;
    }

    @RequestMapping(value = "product/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("productGroups", productGroupRepository.findAll());
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @RequestMapping(value = "product/add", method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute Product product,
            @RequestParam(name = "productGroupId") int productGroupId
            ){
        ProductGroup productGroup = productGroupRepository.findById(productGroupId).get();
        product.setProductGroup(productGroup);
        productGroup.getProducts().add(product);
        productRepository.save(product);
        return "add_product";
    }
}