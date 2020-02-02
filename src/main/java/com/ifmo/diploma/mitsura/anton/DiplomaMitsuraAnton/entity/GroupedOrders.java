package com.ifmo.diploma.mitsura.anton.DiplomaMitsuraAnton.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupedOrders {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int groupId;

    private int groupedOrderSum;

    private String deliveryAddres;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    private String clientName;

    private String clientPassword;

    private String phoneNumber;

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

    public int getGroupedOrderSum() {
        return groupedOrderSum;
    }

    public void setGroupedOrderSum(int groupedOrderSum) {
        this.groupedOrderSum = groupedOrderSum;
    }

    public String getDeliveryAddres() {
        return deliveryAddres;
    }

    public void setDeliveryAddres(String deliveryAddres) {
        this.deliveryAddres = deliveryAddres;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
