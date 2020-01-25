package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.ProductGroup;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductGroupController {
    private ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductGroupController(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    @RequestMapping(value = "productgroup/add", method = RequestMethod.GET)
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("productGroup", new ProductGroup());
        return "add_product_group";
    }

    @RequestMapping(value = "productgroup/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute ProductGroup productGroup){
        productGroupRepository.save(productGroup);
        return "add_product_group";
    }
}
