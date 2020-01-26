package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupedOrders {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int groupId;

    private String clientName;

    private String clientPassword;

    @OneToMany(mappedBy = "groupedOrders",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    public String getClientName() {
        return clientName;
    }

    public GroupedOrders setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public GroupedOrders setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
