package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.controllers;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.GroupedOrders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Orders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Product;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.GroupedOrdersRepository;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.OrdersRepository;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Iterable<Orders> findMyOrders(@RequestBody GroupedOrders groupedOrder) {
        return ordersRepository.findByClientNameAndClientPassword(groupedOrder.getClientName(), groupedOrder.getClientPassword());
    }

    @PostMapping(value = "/orders/id")
    public Iterable<Orders> findById(@RequestBody GroupedOrders groupedOrder) {
        return ordersRepository.findByGroupedOrders(groupedOrder);
    }

    @PostMapping(path = "/orders/add")
    public String addOrder(@RequestBody List<Orders> orders) {
        GroupedOrders groupedOrder = new GroupedOrders().setClientName(orders.get(0).getClientName()).setClientPassword(orders.get(0).getClientPassword());
        for (Orders order : orders) {
            Product product = productRepository.findById(order.getProductId()).get();
            order.setSum(product.getProductPrice() * order.getAmount());
            groupedOrder.setGroupedOrderSum(groupedOrder.getGroupedOrderSum() + order.getSum());
        }
        groupedOrdersRepository.save(groupedOrder);
        GroupedOrders groupedOrderSelectedFromDb = groupedOrdersRepository
                .findByClientNameAndClientPasswordOrderByGroupIdDesc(groupedOrder.getClientName(), groupedOrder.getClientPassword()).iterator().next();
        for (Orders order : orders) {
            order.setGroupedOrders(groupedOrderSelectedFromDb);
            ordersRepository.save(order);
        }
        return "Order Id = " + groupedOrderSelectedFromDb.getGroupId();
    }
}
