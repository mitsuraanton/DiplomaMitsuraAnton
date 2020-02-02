package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.repository;

import com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity.GroupedOrders;
import org.springframework.data.repository.CrudRepository;

public interface GroupedOrdersRepository extends CrudRepository<GroupedOrders, Integer> {
    Iterable<GroupedOrders> findByClientNameAndClientPasswordOrderByGroupIdDesc(String clientName, String clientPassword);
    GroupedOrders findByGroupIdAndClientNameAndClientPassword(int groupId, String clientName, String clientPassword);
}