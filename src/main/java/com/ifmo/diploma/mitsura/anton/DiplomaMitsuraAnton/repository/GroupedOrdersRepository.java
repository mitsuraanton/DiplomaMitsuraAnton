package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.GroupedOrders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GroupedOrdersRepository extends CrudRepository<GroupedOrders, Integer> {
    Iterable<GroupedOrders> findByClientNameAndClientPasswordOrderByGroupIdDesc(String clientName, String clientPassword);
    GroupedOrders findByGroupId(int groupId);
}