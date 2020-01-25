package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Orders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrdersController {
    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping(value = "/orders")
    public Iterable<Orders> findAll(){
        return ordersRepository.findAll(); // вернется JSON строка
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<Orders> findId(@PathVariable int id){
        return ordersRepository.findById(id); // вернется JSON строка
    }

    @PostMapping(path = "/orders/add")
    public void submitForm(@RequestBody Orders order){
        ordersRepository.save(order);
    }
}
