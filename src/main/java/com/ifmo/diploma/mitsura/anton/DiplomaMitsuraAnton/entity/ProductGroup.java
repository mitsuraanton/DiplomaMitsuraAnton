package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductGroup {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String productGroupName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }
}
