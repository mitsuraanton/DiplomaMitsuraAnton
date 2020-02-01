package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.GroupedOrders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Orders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.GroupedOrdersRepository;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.OrdersRepository;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class OrdersController {
    private OrdersRepository ordersRepository;
    private ProductRepository productRepository;
    private GroupedOrdersRepository groupedOrdersRepository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository, ProductRepository productRepository, GroupedOrdersRepository groupedOrdersRepository) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
        this.groupedOrdersRepository = groupedOrdersRepository;
    }

    @PostMapping(path = "/orders/myAll")
    public Iterable<GroupedOrders> findMyOrders(@RequestBody GroupedOrders groupedOrder) {
        return groupedOrdersRepository.findByClientNameAndClientPasswordOrderByGroupIdDesc(groupedOrder.getClientName(), groupedOrder.getClientPassword());
    }

    @PostMapping(value = "/orders/id")
    public GroupedOrders findById(@RequestBody GroupedOrders groupedOrder) {
        return groupedOrdersRepository.findByGroupId(groupedOrder.getGroupId());
    }

    @PostMapping(path = "/orders/add")
    public String addOrder(@RequestBody GroupedOrders groupedOrder) {
        if (groupedOrder.getDeliveryDate().compareTo(LocalDate.now()) <= 0) {
            return "Order was not created. Delivery date should not be before tomorrow. Delivery date: " + groupedOrder.getDeliveryDate();
        }
        for (Orders order : groupedOrder.getOrders()) {
            Product product = productRepository.findById(order.getProductId()).get();
            order.setSum(product.getProductPrice() * order.getAmount());
            groupedOrder.setGroupedOrderSum(groupedOrder.getGroupedOrderSum() + order.getSum());
        }
        groupedOrdersRepository.save(groupedOrder);
        GroupedOrders groupedOrderSelectedFromDb = groupedOrdersRepository
                .findByClientNameAndClientPasswordOrderByGroupIdDesc(groupedOrder.getClientName(), groupedOrder.getClientPassword()).iterator().next();
        for (Orders order : groupedOrder.getOrders()) {
            order.setGroupedOrders(groupedOrderSelectedFromDb);
            ordersRepository.save(order);
        }
        return "Order Id = " + groupedOrderSelectedFromDb.getGroupId();


    }
}
