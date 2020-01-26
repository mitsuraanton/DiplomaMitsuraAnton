package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.GroupedOrders;
import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    Iterable<Orders> findByClientNameAndClientPassword(String clientName, String clientPassword);
    Iterable<Orders> findByGroupedOrders(GroupedOrders groupedOrder);
}