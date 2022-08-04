package com.appdynamics.demo.java.order.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private UUID id;
    private Customer customer;
    private List<OrderPosition> positions = new LinkedList<>();

}
