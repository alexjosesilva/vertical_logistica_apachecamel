package com.example.vertical_logistica_apachecamel.model;

import java.util.List;

public class Pedido {
    private int userId;
    private String name;
    private List<Order> orders;

    // Getters e Setters


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
